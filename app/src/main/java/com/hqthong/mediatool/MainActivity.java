package com.hqthong.mediatool;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.hqthong.mediatool.adapter.MyPaperAdapter;
import com.hqthong.mediatool.fragment.ImageMainFragment;
import com.hqthong.mediatool.fragment.LiveMainFragment;
import com.hqthong.mediatool.fragment.SettingMainFragment;
import com.hqthong.mediatool.fragment.ToolMainFragment;
import com.hqthong.mediatool.fragment.VideoMainFragment;
import com.hqthong.mediatool.views.CustomViewPager;
import com.hqthong.mediatool.views.MyTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    TabLayout tab_main;
    CustomViewPager cwp_layout;

    MainActivity activity;
    VideoMainFragment frVideo;
    ImageMainFragment frImage;
    LiveMainFragment frLive;
    ToolMainFragment frTool;
    SettingMainFragment frSetting;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private MyPaperAdapter paperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        activity = this;

        tab_main = findViewById(R.id.tab_main);
        cwp_layout = findViewById(R.id.cwp_layout);

        frVideo = VideoMainFragment.newInstance();
        fragments.add(frVideo);
        frImage = ImageMainFragment.newInstance();
        fragments.add(frImage);
        frLive = LiveMainFragment.newInstance();
        fragments.add(frLive);
        frTool = ToolMainFragment.newInstance();
        fragments.add(frTool);
        frSetting = SettingMainFragment.newInstance();
        fragments.add(frSetting);

        paperAdapter = new MyPaperAdapter(this.getSupportFragmentManager(), fragments);
        cwp_layout.setAdapter(paperAdapter);
        cwp_layout.setOffscreenPageLimit(5);
        tab_main.setupWithViewPager(cwp_layout);
        initTabLayout();
    }

    private void initTabLayout() {
        View view0 = activity.getLayoutInflater().inflate(R.layout.item_tablayout, null);
        ((MyTextView) view0.findViewById(R.id.mtv_icon)).setText(R.string.icon_video);
        ((MyTextView) view0.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#ffffff"));
        view0.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(0).setCustomView(view0);

        View view1 = activity.getLayoutInflater().inflate(R.layout.item_tablayout, null);
        ((MyTextView) view1.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_camera);
        ((MyTextView) view1.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#ffffff"));
        view1.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(1).setCustomView(view1);

        View view2 = activity.getLayoutInflater().inflate(R.layout.item_tablayout, null);
        ((MyTextView) view2.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_play_circle);
        ((MyTextView) view2.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#ffffff"));
        view2.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(2).setCustomView(view2);

        View view3 = activity.getLayoutInflater().inflate(R.layout.item_tablayout, null);
        ((MyTextView) view3.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_tune);
        ((MyTextView) view3.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#ffffff"));
        view3.findViewById(R.id.mtv_notice).setVisibility(View.GONE);
        tab_main.getTabAt(3).setCustomView(view3);

        View view4 = activity.getLayoutInflater().inflate(R.layout.item_tablayout, null);
        ((MyTextView) view4.findViewById(R.id.mtv_icon)).setTextPersonName(R.string.icon_setting);
        ((MyTextView) view4.findViewById(R.id.mtv_icon)).setTextColor(Color.parseColor("#ffffff"));
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
