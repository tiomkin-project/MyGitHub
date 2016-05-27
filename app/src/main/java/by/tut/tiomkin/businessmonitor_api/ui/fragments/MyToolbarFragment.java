package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.tut.tiomkin.businessmonitor_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyToolbarFragment extends BaseFragment {

    private static final String TAG = MyToolbarFragment.class.getSimpleName();


    public MyToolbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_toolbar, container, false);
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
