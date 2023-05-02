package lewis.com.yuyue.ui.act;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseActivity;
import lewis.com.yuyue.bean.ChatList;
import lewis.com.yuyue.bean.DocList;
import lewis.com.yuyue.bean.Login;
import lewis.com.yuyue.bean.NewsList;
import lewis.com.yuyue.utils.ACache;
import lewis.com.yuyue.utils.Contance;
import lewis.com.yuyue.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2021/2/28.
 */

public class ChatAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.et_content)
    EditText etContent;
    private DocList.DataBean bean;

    private List<ChatList.DataBean> beans=new ArrayList<>();
    private SimpleAdapter<ChatList.DataBean> adapter;
    private String uid;
    private myHandel handel;
    private String sessionid;

    @Override
    public int intiLayout() {
        return R.layout.act_chat;
    }

    @Override
    public void initView() {
        handel = new myHandel();

        uid = ACache.get(this).getAsString("id");
        Bundle extras = getIntent().getExtras();
        bean = (DocList.DataBean) extras.getSerializable("bean");
        sessionid = extras.getString("sessionid");
        tvTitle.setText(bean.name);
        ivBack.setVisibility(View.VISIBLE);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleAdapter<ChatList.DataBean>(R.layout.item_chat, beans, new SimpleAdapter.ConVert<ChatList.DataBean>() {
            @Override
            public void convert(BaseViewHolder helper, ChatList.DataBean dataBean) {
                     if (uid.equals(dataBean.sid+"")){
                         helper.getView(R.id.ll_left).setVisibility(View.GONE);
                         helper.getView(R.id.ll_right).setVisibility(View.VISIBLE);
                         helper.setText(R.id.tv_right_name,dataBean.sname);
                         helper.setText(R.id.tv_right_content,dataBean.content);
                         CircleImageView view = helper.getView(R.id.ll_right_img);
                         Glide.with(ChatAct.this).load(dataBean.simg).into(view);
                     }else {
                         helper.getView(R.id.ll_right).setVisibility(View.GONE);
                         helper.getView(R.id.ll_left).setVisibility(View.VISIBLE);
                         helper.setText(R.id.tv_left_name,dataBean.sname);
                         helper.setText(R.id.tv_left_content,dataBean.content);
                         CircleImageView view = helper.getView(R.id.ll_left_img);
                         Glide.with(ChatAct.this).load(dataBean.simg).into(view);
                     }
            }
        });
        recycler.setAdapter(adapter);
    }
    private Login.DataBean userdata;
    //查询用户信息
    private void getInfo(){
        OkHttpUtils
                .post()
                .url(Contance.getUserInfo)
                .addParams("id", uid+"")

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
                            userdata = login.data;

                        }
                    }
                });

    }
    @Override
    public void initData() {
            getdata();
            getInfo();
            handel.sendEmptyMessageDelayed(1,2000);
    }

    //获取数据
    private void getdata() {
        beans.clear();
        adapter.notifyDataSetChanged();
        OkHttpUtils
                .post()
                .url(Contance.getMyChat)
                .addParams("sessionid",sessionid)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final ChatList comResult = new Gson().fromJson(response, ChatList.class);
                        if (comResult != null && comResult.data != null) {
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    beans.addAll(comResult.data);
                                    adapter.notifyDataSetChanged();
                                    recycler.scrollToPosition(adapter.getItemCount()-1);
                                }
                            });


                        }
                    }
                });
    }
    private void send(String content) {
        OkHttpUtils
                .post()
                .url(Contance.addChat)
                .addParams("sid",uid)
                .addParams("sname",userdata.name+"")
                .addParams("simg",userdata.img+"")
                .addParams("content",content)
                .addParams("gid",bean.id+"")
                .addParams("gname",bean.name+"")
                .addParams("gimg",bean.img+"")
                .addParams("sessionid",sessionid)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final ChatList comResult = new Gson().fromJson(response, ChatList.class);
                        if (comResult != null) {
                              toast(comResult.msg);
                              etContent.setText("");
                              getdata();
                        }
                    }
                });
    }

    @OnClick({R.id.iv_back, R.id.tv_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_send:
                String content = etContent.getText().toString();
                if (TextUtils.isEmpty(content)){
                    toast("请输入");
                    return;
                }
                send(content);
                break;
        }
    }

    public class myHandel extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getdata();
        }
    }
}
