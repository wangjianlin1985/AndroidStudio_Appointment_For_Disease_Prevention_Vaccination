package lewis.com.yuyue.ui.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseActivity;
import lewis.com.yuyue.bean.NewsList;

/**
 * Created by Administrator on 2021/2/25.
 */

public class NewsDetialAct extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int intiLayout() {
        return R.layout.act_shcool_detial;
    }

    @Override
    public void initView() {
        Bundle extras = getIntent().getExtras();
        NewsList.DataBean bean = (NewsList.DataBean) extras.getSerializable("bean");


        tvContent.setText(bean.content);
        tvTitle.setText(bean.title);
        ivBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
}
