package com.hqthong.mediatool.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hqthong.mediatool.R;

import java.util.HashMap;
import java.util.Map;

public class WidgetUtil {

    public static TextInf _textInf;

    public interface TextInf {
        CharSequence getText(String lang);
    }

    public static void init(TextView _this, Map<String, Typeface> mTypefaces, final Context context, final AttributeSet attrs) {
        if (mTypefaces == null) {
            mTypefaces = new HashMap<>();
        }

        // prevent exception in Android Studio / ADT interface builder
        if (_this.isInEditMode()) {
            return;
        }

        final TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        if (array != null) {
            final String typefaceAssetPath = array.getString(R.styleable.MyTextView_typeface);

            if (typefaceAssetPath != null) {
                Typeface typeface;

                if (mTypefaces.containsKey(typefaceAssetPath)) {
                    typeface = mTypefaces.get(typefaceAssetPath);
                } else {
                    AssetManager assets = context.getAssets();
                    typeface = Typeface.createFromAsset(assets, typefaceAssetPath);
                    mTypefaces.put(typefaceAssetPath, typeface);
                }

                _this.setTypeface(typeface);
            }

            // set language follow key
            if (_textInf != null) {

                // Text
                final String lang = array.getString(R.styleable.MyTextView_lang);
                if (lang != null) {
                    CharSequence val = _textInf.getText(lang);
                    if (val != null) {
                        _this.setText(val);
                    }
                }


                // Hint
                final String langHint = array.getString(R.styleable.MyTextView_langhint);
                if (langHint != null) {
                    CharSequence val = _textInf.getText(langHint);
                    if (val != null) {
                        _this.setHint(val);
                    }
                }

            }


            if (_textInf != null)
                array.recycle();
        }
    }
}
