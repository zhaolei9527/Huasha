package com.zzcn77.CBMMART;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author SAKURA
 */
public abstract class HidingScrollListener extends RecyclerView.OnScrollListener {

    private static final int SCROLL_DISTANCE = 50;
    private int totalScrollDistance;
    private boolean isShow = true;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisableItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        //当第一个item存在界面上时就不触发隐藏、显示操作
        if (firstVisableItem == 0) {
            return;
        }
        if ((dy > 0 && isShow) || (dy < 0 && !isShow)) {
            totalScrollDistance += dy;
        }
        if (totalScrollDistance > SCROLL_DISTANCE && isShow) {
            hide();
            isShow = false;
            totalScrollDistance = 0;
        } else if (totalScrollDistance < -SCROLL_DISTANCE && !isShow) {
            show();
            isShow = true;
            totalScrollDistance = 0;
        }
    }

    public abstract void hide();

    public abstract void show();

}
