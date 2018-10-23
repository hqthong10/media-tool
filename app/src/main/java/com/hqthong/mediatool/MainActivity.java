package com.hqthong.mediatool;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hqthong.mediatool.views.CustomViewPager;
import com.hqthong.mediatool.views.MyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.tab_main)
    TabLayout tab_main;
    @BindView(R.id.cwp_layout)
    CustomViewPager cwp_layout;

    MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activity = this;
    }

    private void initTabLayout() {
        View view0 = LayoutInflater.from(activity).inflate(R.layout.item_tablayout, null);
        //((MyTextView) view0.findViewById(R.id.title)).setTypeface(Typeface.createFromAsset(activity.getAssets(), activity.getResources().getString(R.string.fonts_helveticaneue_light)));
        ((MyTextView) view0.findViewById(R.id.mtv_icon)).setText(R.string.icon_video);
        ((MyTextView) view0.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#000000"));
        view0.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(0).setCustomView(view0);

        View view1 = LayoutInflater.from(activity).inflate(R.layout.item_tablayout, null);
        //((MyTextView) view1.findViewById(R.id.title)).setTypeface(Typeface.createFromAsset(activity.getAssets(), activity.getResources().getString(R.string.fonts_helveticaneue_light)));
        ((MyTextView) view1.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_camera);
        ((MyTextView) view1.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#000000"));
        view1.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(1).setCustomView(view1);

        View view2 = LayoutInflater.from(activity).inflate(R.layout.item_tablayout, null);
        //((MyTextView) view2.findViewById(R.id.mtv_icon)).setTypeface(Typeface.createFromAsset(activity.getAssets(), activity.getResources().getString(R.string.fonts_helveticaneue_light)));
        ((MyTextView) view2.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_play_circle);
        ((MyTextView) view2.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#000000"));
        view2.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(2).setCustomView(view2);

        View view3 = LayoutInflater.from(activity).inflate(R.layout.item_tablayout, null);
        //((MyTextView) view3.findViewById(R.id.mtv_icon)).setTypeface(Typeface.createFromAsset(activity.getAssets(), activity.getResources().getString(R.string.fonts_helveticaneue_light)));
        ((MyTextView) view3.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_tune);
        ((MyTextView) view3.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#000000"));
        view3.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(3).setCustomView(view3);

        View view4 = LayoutInflater.from(activity).inflate(R.layout.item_tablayout, null);
        //((MyTextView) view4.findViewById(R.id.mtv_icon)).setTypeface(Typeface.createFromAsset(activity.getAssets(), activity.getResources().getString(R.string.fonts_helveticaneue_light)));
        ((MyTextView) view4.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_setting);
        ((MyTextView) view4.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#000000"));
        view4.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(4).setCustomView(view4);
    }

    public void setOrientation(int orientation) {
        setRequestedOrientation(orientation);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
