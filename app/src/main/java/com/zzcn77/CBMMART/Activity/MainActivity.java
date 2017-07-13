package com.zzcn77.CBMMART.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import com.zzcn77.CBMMART.Adapter.MyAdapter;
import com.zzcn77.CBMMART.Bean.Person;
import com.zzcn77.CBMMART.HidingScrollListener;
import com.zzcn77.CBMMART.R;
import com.zzcn77.CBMMART.View.ProgressView;
import java.util.ArrayList;
import java.util.List;
import me.fangx.haorefresh.HaoRecyclerView;
import me.fangx.haorefresh.LoadMoreListener;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolBar;
    SwipeRefreshLayout refresh;
    HaoRecyclerView mRecyclerView;
    List<Person> mList;
    MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initView();
        initData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
    }

    private void initData() {

    }

    private void initToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.tool_bar);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolBar);
    }

    private void initView() {
        mList = new ArrayList<>();
        refresh= (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setProgressViewEndTarget(false, (int) getResources().getDimension(R.dimen.x105));
        refresh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary,R.color.colorPrimaryDark);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.loadMoreComplete();
                        mList.clear();
                        getData();
                        refresh.setRefreshing(false);
                        mAdapter.notifyDataSetChanged();
                    }
                },2000);
            }
        });

        mRecyclerView= (HaoRecyclerView) findViewById(R.id.ce_shi_lv);
        LinearLayoutManager line=new LinearLayoutManager(this);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(line);

        ProgressView progressView=new ProgressView(this);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(0xff69b3e0);
        mRecyclerView.setFootLoadingView(progressView);

        TextView textView=new TextView(this);
        textView.setText("已经到底了");
        mRecyclerView.setFootEndView(textView);
        mRecyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mList.size()>=30){
                            mRecyclerView.loadMoreEnd();
                            return;
                        }else {
                            getData();
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.loadMoreComplete();
                    }
                },2000);
            }
        });
        getData();
        mAdapter=new MyAdapter(mList,this);
        mRecyclerView.setAdapter(mAdapter);
        //已经封装好的点击事件
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "click-----position" + i, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void hide() {
                mToolBar.animate().translationY(-mToolBar.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator());
            }

            @Override
            public void show() {
                mToolBar.animate().translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });
    }

    public void getData(){
        for (int i = 0; i <10 ; i++) {
            Person p=new Person("小明+"+i);
            mList.add(p);
        }
    }
}
