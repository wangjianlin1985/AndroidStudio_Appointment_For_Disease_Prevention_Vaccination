package lewis.com.yuyue.ui.act;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseActivity;
import lewis.com.yuyue.bean.DocLogin;
import lewis.com.yuyue.bean.Login;
import lewis.com.yuyue.bean.SessionList;
import lewis.com.yuyue.utils.ACache;
import lewis.com.yuyue.utils.Contance;
import lewis.com.yuyue.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2021/3/17.
 */

public class DocMainActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.iv_img)
    CircleImageView ivImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    private String uid;
    private List<SessionList.DataBean> beans=new ArrayList<>();
    private SimpleAdapter<SessionList.DataBean> adapter;

    @Override
    public int intiLayout() {
        return R.layout.activity_main1;
    }

    @Override
    public void initView() {
        uid = ACache.get(this).getAsString("id");
        tvTitle.setText("咨询列表");

        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleAdapter<SessionList.DataBean>(R.layout.item_session, beans, new SimpleAdapter.ConVert<SessionList.DataBean>() {
            @Override
            public void convert(BaseViewHolder helper, SessionList.DataBean dataBean) {
                getUserInfo(helper,dataBean.uid);
            }
        });
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString("uid",beans.get(position).uid+"");
                bundle.putString("sessionid",beans.get(position).id+"");
                jumpAct(DocChatAct.class,bundle);
            }
        });
    }

    @Override
    public void initData() {
        getdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getInfo();
    }
    //查询用户信息
    private void getUserInfo(final BaseViewHolder helper, int id){
        OkHttpUtils
                .post()
                .url(Contance.getUserInfo)
                .addParams("id", id+"")

                .build()
                .execute(new StringCallback() {


                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final Login login = new Gson().fromJson(response, Login.class);
                        if (login!=null&&login.data!=null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //渲染用户信息到页面
                                    Login.DataBean data = login.data;
                                    helper.setText(R.id.tv_left_name,TextUtils.isEmpty(data.name)?data.account:data.name);

                                    CircleImageView view = helper.getView(R.id.ll_left_img);
                                    Glide.with(DocMainActivity.this).load(data.img).into(view);


                                }
                            });

                        }
                    }
                });

    }

    //获取数据
    private void getdata() {
        beans.clear();
        adapter.notifyDataSetChanged();
        OkHttpUtils
                .post()
                .url(Contance.getMySession)
                .addParams("did",uid+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final SessionList comResult = new Gson().fromJson(response, SessionList.class);
                        if (comResult != null && comResult.data != null) {
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    beans.addAll(comResult.data);
                                    adapter.notifyDataSetChanged();
                                }
                            });


                        }
                    }
                });
    }
    //查询用户信息
    private void getInfo(){
        OkHttpUtils
                .post()
                .url(Contance.getdocInfo)
                .addParams("id", uid+"")

                .build()
                .execute(new StringCallback() {


                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final DocLogin login = new Gson().fromJson(response, DocLogin.class);
                        if (login!=null&&login.data!=null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //渲染用户信息到页面
                                    DocLogin.DataBean data = login.data;
                                    tvName.setText(TextUtils.isEmpty(data.name)?data.account:data.name);


                                    Glide.with(DocMainActivity.this).load(data.img).into(ivImg);


                                }
                            });

                        }
                    }
                });

    }
    @OnClick({R.id.tv_userinfo, R.id.tv_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_userinfo:
                jumpAct(DocUserInfoAct.class);
                break;
            case R.id.tv_exit:
                ACache.get(DocMainActivity.this).clear();
                jumpAct(LoginActivity.class);
                finish();
                break;
        }
    }
}
