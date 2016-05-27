package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.tut.tiomkin.businessmonitor_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends BaseFragment {

    private static final String TAG = SearchResultFragment.class.getSimpleName();


    public SearchResultFragment() {
        // Required empty public constructor
    }

    public static SearchResultFragment getInstance(FragmentManager fragmentManager) {
        Log.d(TAG, "getInstance");
        SearchResultFragment searchFragment = (SearchResultFragment) fragmentManager.findFragmentByTag(SearchResultFragment.TAG);

        if (searchFragment == null) {
            searchFragment = new SearchResultFragment();
        }

        return searchFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false);
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
