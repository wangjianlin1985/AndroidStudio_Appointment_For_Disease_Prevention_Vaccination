package lewis.com.yuyue.ui.frg;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import lewis.com.yuyue.R;
import lewis.com.yuyue.base.BaseFragment;
import lewis.com.yuyue.bean.DocList;
import lewis.com.yuyue.ui.act.DoctorDetialAct;
import lewis.com.yuyue.utils.Contance;
import lewis.com.yuyue.utils.SimpleAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2019/12/11.
 */
//
public class DoctorFrg extends BaseFragment {
    //初始化控件
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<DocList.DataBean> beanList=new ArrayList<>();

    private SimpleAdapter<DocList.DataBean> adapter;
    private AlertDialog alertDialog;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.frg_home, container, false);
    }


    @Override
    public void initData() {
        super.initData();
        tvTitle.setText("医生列表");



        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        //给列表绑定adapter并渲染数据
        adapter = new SimpleAdapter<DocList.DataBean>(R.layout.item_book, beanList, new SimpleAdapter.ConVert<DocList.DataBean>() {
            @Override
            public void convert(final BaseViewHolder helper, DocList.DataBean dataBean) {
                helper.setText(R.id.tv_name, dataBean.name);

                helper.setText(R.id.tv_position, dataBean.position);
                helper.setText(R.id.tv_department,dataBean.department );

            }
        });
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("bean",beanList.get(position));
                jumpAct(DoctorDetialAct.class,bundle);
            }
        });
    }




    //获取数据
    private void getdata(){
        beanList.clear();
        OkHttpUtils
                .post()
                .url(Contance.getDoctors)

                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("sss",e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        final DocList comResult = new Gson().fromJson(response, DocList.class);
                        if (comResult!=null&&comResult.data!=null){
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

}
