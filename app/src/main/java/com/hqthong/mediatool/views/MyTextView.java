package com.hqthong.mediatool.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hqthong.mediatool.util.WidgetUtil;

import java.text.DecimalFormat;
import java.util.Map;

public class MyTextView extends AppCompatTextView {
    /*
     * Caches typefaces based on their file path and name, so that they don't have to be created
     * every time when they are referenced.
     */
    public static Map<String, Typeface> mTypefaces;

    public MyTextView(final Context context) {
        super(context);
        init(context, null);
    }

    public MyTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attrs) {
        WidgetUtil.init(this, mTypefaces, context, attrs);
    }

    //Animate TextView to increase integer and stop at some point
    public static void animateTextView(int initialValue, int finalValue, final TextView textview, int aimDuration) {
        final DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        ValueAnimator valueAnimator = ValueAnimator.ofInt(initialValue, finalValue);
        valueAnimator.setDuration(aimDuration);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                textview.setText(formatter.format(valueAnimator.getAnimatedValue()) + ""); //valueAnimator.getAnimatedValue().toString());
            }
        });
        valueAnimator.start();
    }


    /**
     * @param idRes R.id.txt
     * @input: tư lầu
     * @return Tư Lầu
     */
    public void setTextPersonName(int idRes) {
        String[] parts = getContext().getString(idRes).toString().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            char[] chars = part.toLowerCase().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            sb.append(new String(chars)).append(" ");
        }
        this.setText(sb.toString().trim());
    }

    public void setTextPersonName(String text) {
        String[] parts = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            char[] chars = part.toLowerCase().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            sb.append(new String(chars)).append(" ");
        }
        this.setText(sb.toString().trim());
    }
}
