package com.example.picassotest.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Scroller;

/**
 * Created by shangzhaohui on 16/3/25.
 */
public class ExpendListView extends ListView {
    public static final String TAG = "ExpendListView";
    private View mExpandView;
    private Scroller mScroller;
    public ExpendListView(Context context) {
        super(context);
        init(context);
    }

    public ExpendListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ExpendListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    float startX;
    float startY;

    float orginalY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();


        switch (action) {
            case MotionEvent.ACTION_DOWN:

                startX = ev.getX();
                startY = ev.getY();
                orginalY = mExpandView.getHeight();
//                Log.e(TAG, "x " + startX);
//                Log.e(TAG,"y " + startY);
                break;
            case MotionEvent.ACTION_MOVE:
                float currentY = ev.getY();

                if (currentY >startY) {
                    float deta = currentY- startY;
                    startY = currentY;

                    int height = mExpandView.getHeight();
                    int width = mExpandView.getWidth();
                    int newHight = (int) ((orginalY+deta/2.5f));
                    int newWidth = height/width * height;

                    mExpandView.setLayoutParams(new AbsListView.LayoutParams(width,
                           newHight ));
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
//                mExpandView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                        (int) (orginalY)));

                Log.e(TAG, "scroll " + (int)(orginalY-mExpandView.getHeight()));
                mScroller.startScroll(0,mExpandView.getHeight(),0,(int)(orginalY-mExpandView.getHeight()),200);
                invalidate();
                break;

        }
        return super.dispatchTouchEvent(ev);

    }

    public void setExpandView(View mExpandView) {
        this.mExpandView = mExpandView;
        addHeaderView(mExpandView);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            int y = mScroller.getCurrY();
            mExpandView.setLayoutParams(new AbsListView.LayoutParams(mExpandView.getWidth(),y));
        }else {
            super.computeScroll();
        }
    }
}
