package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import by.tut.tiomkin.businessmonitor_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends BaseFragment {

    private static final String TAG = SearchResultFragment.class.getSimpleName();
    private static final String BAD_COMPANIES_COUNT = "badCompaniesCount";
    private static final String DISPUTES_COUNT = "disputesCount";

    TextView mBadCompanies, mDisputes;


    public SearchResultFragment() {
        // Required empty public constructor
    }

    public static SearchResultFragment getInstance(FragmentManager fragmentManager, HashMap<Integer, Integer> dataForSet) {
        Log.d(TAG, "getInstance");
        SearchResultFragment searchFragment = (SearchResultFragment) fragmentManager.findFragmentByTag(SearchResultFragment.TAG);

        if (searchFragment == null) {
            searchFragment = new SearchResultFragment();
        }

        //TODO написать код получения данных из map и затем упаковать данные в Bundle
        setBundles(dataForSet, searchFragment);

        return searchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        mBadCompanies = (TextView) view.findViewById(R.id.tv_badCompanies);
        mDisputes = (TextView) view.findViewById(R.id.tv_disputes);

        //TODO Здесь написать код получения данных из Bundle и вывода во view
        Bundle bundle = getArguments();
        if (bundle != null) {
            int badCompaniesCount = bundle.getInt(BAD_COMPANIES_COUNT);
            int disputesCount = bundle.getInt(DISPUTES_COUNT);
            if (badCompaniesCount == 0) {
                mBadCompanies.setText("не вкл.");
            } else {
                mBadCompanies.setText("вкл.");
            }
            if (disputesCount>0) {
                mDisputes.setText(String.valueOf(disputesCount) + ">>");
            } else {
                mDisputes.setText(String.valueOf(disputesCount));
            }
        }

        return view;
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }

    private static void setBundles(HashMap<Integer, Integer> dataForSet, SearchResultFragment searchFragment) {
        Bundle bundle = new Bundle();
        int badCompaniesCount = dataForSet.get(0);
        int casesCount = dataForSet.get(1);
        bundle.putInt(BAD_COMPANIES_COUNT, badCompaniesCount);
        bundle.putInt(DISPUTES_COUNT, casesCount);
        searchFragment.setArguments(bundle);
    }
}
