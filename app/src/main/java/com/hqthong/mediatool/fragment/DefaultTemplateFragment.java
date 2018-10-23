package com.hqthong.mediatool.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import com.hqthong.mediatool.MainActivity;

public abstract class DefaultTemplateFragment extends Fragment {
    private static long TIME_UPDATE_CURENT = 0;

    public MainActivity activity;
    public final Handler mHandler = new Handler();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

//    public void updateUserOnline(final MainActivity activity, final MyCallBackNextInf myCallBackNextInf) {
//        LogUtil.e(">> ", TIME_UPDATE_CURENT);
//        LogUtil.e(">> ", System.currentTimeMillis());
//        TIME_UPDATE_CURENT = Math.abs(System.currentTimeMillis() - TIME_UPDATE_CURENT);
//        LogUtil.e(">> ", TIME_UPDATE_CURENT);
//        if (TIME_UPDATE_CURENT >= 1 * 60 * 1000) {
//            TIME_UPDATE_CURENT = System.currentTimeMillis();
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        LogUtil.e(">> " + Constants.GETUSERSONLINEBYUSER, "RUN");
//                        JSONObject obj = new JSONObject();
//                        obj.put("fo100", activity.user.getFO100());
//                        activity.mSocket.emit(Constants.GETUSERSONLINEBYUSER, obj.toString(), new Ack() {
//                            @Override
//                            public void call(final Object... args) {
//                                try {
//                                    mHandler.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            try {
//                                                if (args[0] instanceof JSONArray) {
//                                                    LogUtil.e(Constants.TAG, args[0].toString());
//                                                    new ContactHelper(activity).updateFriendOnline(args[0].toString().replace("[", "(").replace("]", ")"));
//                                                    myCallBackNextInf.whenSuccess(true);
//                                                }
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
//                                    });
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, 200);
//        }
//    }


    public boolean isSafe() {
        return !(this.isRemoving() || this.getActivity() == null || this.isDetached() || !this.isAdded() || this.getView() == null);
    }


    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
        //round(200.3456, 2); // returns 200.35
    }

//    public  void callCloseFragment( Fragment fragment) {
//        getChildFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
////        mHandler.post(new Runnable() {
////            @Override
////            public void run() {
////
////            }
////        });
//    }

}