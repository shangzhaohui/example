package com.example.picassotest.app.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by shangzhaohui on 16/3/27.
 */
public class MyImageView extends ImageView {
    public enum Style {
        RECTANGLE,
        POLYGON
    }
    private Context mContext;

    private Style mStyle= Style.RECTANGLE;

    ArrayList<Point> mPointList = new ArrayList<>();


    private Paint mPaint;
    public MyImageView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

boolean need =false;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mStyle == Style.RECTANGLE) {
            mPaint.setStyle(Paint.Style.STROKE);
            float left = startX > endX ? endX:startX;
            float top = startY > endY ? endY:startY;
            float right = startX > endX ? startX:endX;
            float bottom = startY > endY ? startY:endY;
            canvas.drawRect(left, top, right, bottom, mPaint);
        }else {
                canvas.drawPath(getPath(mPointList),mPaint);
        }

    }
    private float startX, startY;
    private float endX, endY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (mStyle == Style.RECTANGLE) {
                    startX = event.getX()<0?0:event.getX();
                    startY = event.getY()<0?0:event.getY();
                }else {
                    Point p = new Point((int)event.getX(),(int)event.getY());
                    mPointList.add(p);
                    Log.e("MyImageView ", "size add " + mPointList.size());
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (mStyle == Style.RECTANGLE) {
                    endX = event.getX()>getWidth()?getWidth():event.getX();
                    endY = event.getY()>getHeight()?getHeight():event.getY();
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        return true;
    }

    @Override
    public void setBackgroundResource(int resid) {
        setBackground(null);
//        if (getBitmap() != null) {
//            getBitmap().recycle();
//        }

        setImageBitmap(null);
        super.setBackgroundResource(resid);

        orginalBitmap = BitmapFactory.decodeResource(mContext.getResources(),resid);
        reset();
    }
    public void  setBitmap() {
        if (mStyle ==Style.RECTANGLE) {


            float left = startX > endX ? endX:startX;
            float top = startY > endY ? endY:startY;
            if (left <=0 || top <=0) {
                return;
            }
            Bitmap bitmap = getBitmap();
            setImageBitmap(null);
            setBackground(null);
            orginalBitmap = Bitmap.createBitmap(bitmap, (int) left, (int) top, (int) Math.abs(endX - startX), (int)
                    Math.abs(endY - startY));
            setImageBitmap(orginalBitmap);
//            bitmap.recycle();

            setDrawingCacheEnabled(false);
            reset();
        }else {
           float minX=10000,minY=10000,maxX=0,maxY=0;
            for (Point p: mPointList) {
                if (minX > p.x) {
                    minX = p.x;
                }
                if (minY > p.y) {
                    minY = p.y;
                }
                if (maxX<p.x) {
                    maxX = p.x;
                }
                if (maxY<p.y) {
                    maxY = p.y;
                }
            }
            ArrayList<Point> list = new ArrayList<>();
            for (Point p: mPointList
                 ) {
                Point point = new Point();
                point.x = (int)(p.x-minX);
                point.y=(int)(p.y-minY);
                list.add(point);
            }

            Bitmap bitmap= getBitmap();

            width = (int)(maxX-minX)> bitmap.getWidth()? bitmap.getWidth():(int)(maxX-minX);
            heigh = (int)(maxY-minY)>bitmap.getHeight()? bitmap.getHeight():(int)(maxY-minY);
            if (width <=0 || heigh<=0) {
                return;
            }
            orginalBitmap = Bitmap.createBitmap(bitmap, (int) minX, (int) minY, width, heigh);


            setImageBitmap(null);
            setBackground(null);
            mPointList.clear();
//            setImageBitmap(orginalBitmap);

           //TODO
            Canvas canvas = new Canvas(orginalBitmap);

            canvas.drawARGB(0, 0, 0, 0);
            Paint p = new Paint();
            p.setColor(Color.WHITE);
            p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Path path = getPath(list);
            path.setFillType(Path.FillType.INVERSE_WINDING);
            canvas.drawPath(path, p);

            setImageBitmap(orginalBitmap);


            setDrawingCacheEnabled(false);
            reset();
        }

    }
    int width;
    int heigh;

    Bitmap orginalBitmap;
    public Bitmap getBitmap() {

        return orginalBitmap;
    }
    public void changeStyle() {
        if (mStyle ==Style.RECTANGLE) {
            mStyle = Style.POLYGON;
        }else {
            mStyle = Style.RECTANGLE;
        }
    }

    public String getStyleStr() {
        if (mStyle ==Style.POLYGON) {
            return "多边形";
        }
        return  "矩形";
    }
    private  void reset() {
        startX =0;
        startY =0;
        endX =0;
        endY = 0;
        mPointList.clear();
    }

    private Path  getPath(ArrayList<Point> pointList) {
        Path path = new Path();
        boolean first = true;
        for (Point p:pointList) {
            if (first) {
                path.moveTo(p.x,p.y);
                first =false;
            }else {
                path.lineTo(p.x,p.y);
            }
        }
        path.close();
        return path;
    }
}
