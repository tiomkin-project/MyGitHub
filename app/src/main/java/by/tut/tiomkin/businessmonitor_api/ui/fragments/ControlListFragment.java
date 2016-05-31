package by.tut.tiomkin.businessmonitor_api.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import by.tut.tiomkin.businessmonitor_api.constants.Defaults;
import by.tut.tiomkin.businessmonitor_api.listeners.MyListener;

public class ControlListFragment extends BaseFragment{

    private static final String TAG = ControlListFragment.class.getSimpleName();
    private MyListener mMyListener;

    public ControlListFragment getInstance(FragmentManager fragmentManager) {
        Log.d(TAG, "getInstance");

        ControlListFragment controlListFragment = (ControlListFragment) fragmentManager.findFragmentByTag(ControlListFragment.TAG);

        if (controlListFragment == null) {
            controlListFragment = new ControlListFragment();
        }

        return controlListFragment;
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyListener) {
            mMyListener = (MyListener) context;
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onDetach() {
        mMyListener = null;
        setHasOptionsMenu(false);
        super.onDetach();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mMyListener != null) mMyListener.setTitle(Defaults.CONTROLLIST_FRAGMENT_TITLE);
    }
}
