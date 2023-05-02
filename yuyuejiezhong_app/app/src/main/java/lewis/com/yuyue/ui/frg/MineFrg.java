package lewis.com.yuyue.ui.frg;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseFragment;
import lewis.com.yuyue.bean.Login;
import lewis.com.yuyue.ui.act.AboutAct;
import lewis.com.yuyue.ui.act.LoginActivity;
import lewis.com.yuyue.ui.act.UserInfoAct;
import lewis.com.yuyue.utils.ACache;
import lewis.com.yuyue.utils.Contance;
import okhttp3.Call;

/**
 * Created by Administrator on 2019/12/11.
 */
//消息页面
public class MineFrg extends BaseFragment {
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.iv)
    CircleImageView iv;
    private String uid;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {

        return inflater.inflate(R.layout.frg_msg, container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        uid = ACache.get(getActivity()).getAsString("id");
        getInfo();

    }

    @Override
    public void initData() {
        super.initData();
    }
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
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //渲染用户信息到页面
                                    Login.DataBean data = login.data;
                                    tvAccount.setText(TextUtils.isEmpty(data.name)?data.account:data.name);


                                    Glide.with(getActivity()).load(data.img).into(iv);


                                }
                            });

                        }
                    }
                });

    }

    @OnClick({ R.id.tv_exit, R.id.tv_up_pwd, R.id.my_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_up_pwd:
                startActivity(new Intent(mActivity,UserInfoAct.class));
                break;

            case R.id.my_about:
                startActivity(new Intent(mActivity,AboutAct.class));
                break;

            case R.id.tv_exit:
                ACache.get(getActivity()).clear();
                jumpAct(LoginActivity.class);
                mActivity.finish();

                break;
        }
    }
}
