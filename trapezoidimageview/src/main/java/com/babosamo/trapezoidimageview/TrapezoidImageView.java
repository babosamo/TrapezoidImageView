package com.babosamo.trapezoidimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by babosamo on 2016. 10. 27..
 */

public class TrapezoidImageView extends ImageView {

    private final String TAG = TrapezoidImageView.class.getSimpleName();
    private int leftTopGap;
    private int leftBottomGap;
    private int rightTopGap;
    private int rightBottomGap;
    private int fillColor;

    public TrapezoidImageView(Context context) {
        super(context);
    }

    public TrapezoidImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TrapezoidImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TrapezoidImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TrapezoidImageView);
        leftTopGap = a.getDimensionPixelSize(R.styleable.TrapezoidImageView_clipLeftTopGap, 0);
        leftBottomGap = a.getDimensionPixelSize(R.styleable.TrapezoidImageView_clipLeftBottomGap, 0);
        rightTopGap = a.getDimensionPixelSize(R.styleable.TrapezoidImageView_clipRightTopGap, 0);
        rightBottomGap = a.getDimensionPixelSize(R.styleable.TrapezoidImageView_clipRightBottomGap, 0);
        fillColor = a.getColor(R.styleable.TrapezoidImageView_fillColor, 0);
    }


    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
        invalidate();
    }

    private Region r;

    @Override
    protected void onDraw(Canvas canvas) {

        int w = getWidth();
        int h = getHeight();


        Path path = new Path();
        path.moveTo(0, 0 + leftTopGap);
        path.lineTo(0, h - leftBottomGap);
        path.lineTo(w, h - rightBottomGap);
        path.lineTo(w, 0 + rightTopGap);
        path.close();

        canvas.clipPath(path);
        canvas.drawColor(fillColor);

        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        r = new Region();
        r.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        super.onDraw(canvas);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();

        if (r.contains((int) point.x, (int) point.y)) {
            Log.d(TAG, "dispatchTouchEvent in");

        } else {
            Log.d(TAG, "dispatchTouchEvent out");
            return false;
        }
        return super.dispatchTouchEvent(event);
    }

}
