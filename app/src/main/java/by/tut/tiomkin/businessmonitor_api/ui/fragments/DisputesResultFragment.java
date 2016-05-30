package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.support.v4.app.FragmentManager;
import android.util.Log;


public class DisputesResultFragment extends BaseFragment{

    private static final String TAG = DisputesResultFragment.class.getSimpleName();

    public static DisputesResultFragment getInstance(FragmentManager fragmentManager) {
        Log.d(TAG, "getInstance");

        DisputesResultFragment disputesResultFragment = (DisputesResultFragment) fragmentManager.findFragmentByTag(DisputesResultFragment.TAG);

        if (disputesResultFragment == null) {
            disputesResultFragment = new DisputesResultFragment();
        }

        return disputesResultFragment;
    }


    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
