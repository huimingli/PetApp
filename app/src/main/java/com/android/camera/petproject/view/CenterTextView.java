package com.android.camera.petproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * ClassName:CenterTextView
 *
 * @author 00013277
 * @Date 2016年1月8日 下午6:16:46
 * @see
 */
public class CenterTextView extends TextView {

    private StaticLayout myStaticLayout;
    private TextPaint mTextPaint;

    public CenterTextView(Context context, AttributeSet attrs) {

        super(context, attrs);
        initView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        initView();
    }

    private void initView() {

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(getTextSize());
        mTextPaint.setColor(getCurrentTextColor());
        myStaticLayout = new StaticLayout(getText(), mTextPaint, getWidth(), Alignment.ALIGN_CENTER, 1.0f, 0.0f,
                false);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        initView();
        float mHeight = canvas.getHeight();
        canvas.translate(0, mHeight / 3);
        myStaticLayout.draw(canvas);
    }

}
