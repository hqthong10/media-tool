package com.hqthong.mediatool.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hqthong.mediatool.MainActivity;
import com.hqthong.mediatool.R;

/**
 * Created by Dragon on 1/6/17.
 */

public class VideoMainFragment extends DefaultTemplateFragment {
    View parent;


    public static VideoMainFragment newInstance() {
        VideoMainFragment fragmentFirst = new VideoMainFragment();
        Bundle args = new Bundle();
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.fm_video_main, container, false);

        activity = (MainActivity) getActivity();

        bindDataToView();

        return parent;
    }

    private void bindDataToView() {



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
//        Fragment fmSesrchResult = getChildFragmentManager().findFragmentById(R.id.fm_search_result);
//        if (fmSesrchResult != null) {
//            fmSesrchResult.onActivityResult(requestCode, resultCode, data);
//        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    public void callCloseFm(final Fragment fragment) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                getChildFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
            }
        });
    }

    public void pressKeyBack() {

    }

}
