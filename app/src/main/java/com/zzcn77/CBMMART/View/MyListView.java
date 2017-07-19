package com.zzcn77.CBMMART.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 赵磊 on 2017/5/23.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
        setVerticalScrollBarEnabled(true);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVerticalScrollBarEnabled(true);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVerticalScrollBarEnabled(true);
    }

    @Override

/**   只重写该方法，达到使ListView适应ScrollView的效果   */

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
