package lewis.com.yuyue.ui.frg;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseFragment;
import lewis.com.yuyue.bean.NewsList;
import lewis.com.yuyue.ui.act.NewsDetialAct;
import lewis.com.yuyue.ui.act.YuyueAct;
import lewis.com.yuyue.ui.act.YuyueRecordAct;
import lewis.com.yuyue.utils.Contance;
import lewis.com.yuyue.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2021/12/11.
 */
//

public class HomeFrg extends BaseFragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    private List<NewsList.DataBean> beanList = new ArrayList<>();
    private List<NewsList.DataBean> selList = new ArrayList<>();
    private SimpleAdapter<NewsList.DataBean> adapter;
    private AlertDialog alertDialog;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.frg_child, container, false);
    }
    /**
     * 图片加载类
     */
    private class LocalImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }

    private LocalImageLoader mImageLoader;
    private ArrayList<Integer> imagePath=new ArrayList<>();

    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("预约");
        imagePath.add(R.mipmap.b1);
        imagePath.add(R.mipmap.b2);
        imagePath.add(R.mipmap.b3);
        intBanner();
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<NewsList.DataBean>(R.layout.item_news, beanList, new SimpleAdapter.ConVert<NewsList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, NewsList.DataBean dataBean) {
                helper.setText(R.id.tv_title, dataBean.title);
                helper.setText(R.id.tv_time, dataBean.ctime);



            }
        });
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bean", beanList.get(position));
                jumpAct(NewsDetialAct.class, bundle);
            }
        });
    }
    private void intBanner() {
        mImageLoader = new LocalImageLoader();


        //加载器
        banner.setImageLoader(mImageLoader);
        //动画效果
        banner.setBannerAnimation(Transformer.ZoomOutSlide);

        banner.setDelayTime(2500);
        //是否为自动轮播
        banner.isAutoPlay(true);
        //图片小点显示所在位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //图片加载地址
        banner.setImages(imagePath);
        //启动轮播图。
        banner.start();

    }


    //获取数据
    private void getdata() {
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getNews)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss", e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final NewsList comResult = new Gson().fromJson(response, NewsList.class);
                        if (comResult != null && comResult.data != null) {
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    beanList.addAll(comResult.data);
                                    adapter.notifyDataSetChanged();
                                }
                            });


                        }
                    }
                });
    }


    @Override
    public void onResume() {
        super.onResume();
        getdata();

    }



    @OnClick({R.id.tv_yuyue, R.id.tv_jilu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_yuyue:
                jumpAct(YuyueAct.class);
                break;
            case R.id.tv_jilu:
                jumpAct(YuyueRecordAct.class);
                break;
        }
    }
}
