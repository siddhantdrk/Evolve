package com.app.evolve.blurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.app.evolve.R;

public class BlurAndDimView extends View {

    private static final int BLUR_RADIUS = 4;
    private static final int BLUE_ALPHA = 178;
    private static final int MAX_DIM_ALPHA = 127;
    private Paint bitmapPaint;
    private Paint dimPaint;
    private Paint blueSemiTransparentPaint;
    private int menuWidth;
    private int titleHeight;

    private Bitmap image;
    private Rect rectDst;
    private Rect rectSrc;
    private int downSampling;
    private Rect rectRest;

    public BlurAndDimView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        postConstruct();
    }

    public BlurAndDimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        postConstruct();
    }

    public BlurAndDimView(Context context) {
        this(context, null);
        postConstruct();
    }

    private void postConstruct() {
        bitmapPaint = new Paint(Paint.FILTER_BITMAP_FLAG | Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        dimPaint = new Paint();
        blueSemiTransparentPaint = new Paint();
        //You might want to also have a semitransparent overlay over your blurred image, since you can't control what's behind your menu.
        blueSemiTransparentPaint.setColor(getResources().getColor(R.color.primary_color));
        blueSemiTransparentPaint.setAlpha(BLUE_ALPHA);
        menuWidth = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (image != null) {
            canvas.drawBitmap(image, rectSrc, rectDst, bitmapPaint);
            canvas.drawRect(rectDst, blueSemiTransparentPaint);
            canvas.drawRect(rectRest, dimPaint);
        }
    }

    public void handleScroll(float xOffset) {
        if (image != null) {
            rectSrc.right = (int) (image.getWidth() * xOffset);
            rectDst.right = rectSrc.right * downSampling;
            rectRest.left = rectDst.right;
            dimPaint.setAlpha((int) (xOffset * MAX_DIM_ALPHA));
            invalidate();
        }
    }

    public void setImage(Bitmap bmp, int downSampling) {
        Bitmap cropped = Bitmap.createBitmap(bmp, 0, 0, menuWidth / downSampling, getHeight() / downSampling);
        this.image = Blur.fastblur(getContext(), cropped, BLUR_RADIUS, false);
        rectSrc = new Rect(0, 0, bmp.getWidth(), bmp.getHeight());
        rectDst = new Rect(0, 0, menuWidth, getHeight());
        rectRest = new Rect(menuWidth, 0, getWidth(), getHeight());
        this.downSampling = downSampling;
        invalidate();
    }

    public boolean hasImage() {
        return image != null;
    }

    public void clearImage() {
        image = null;
    }
}