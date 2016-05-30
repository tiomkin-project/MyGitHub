package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.BackendlessCollection;

import java.util.HashMap;

import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.listeners.MyListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends BaseFragment {

    private static final String TAG = SearchResultFragment.class.getSimpleName();
    private static final String BAD_COMPANIES_COUNT = "badCompaniesCount";
    private static final String DISPUTES_COUNT = "disputesCount";
    private static HashMap<String, BackendlessCollection> data;
    private MyListener mMyListener;

    TextView mBadCompanies, mDisputes, mUnp;
    static String unp_value;


    public SearchResultFragment() {
        // Required empty public constructor
    }

    public static SearchResultFragment getInstance(FragmentManager fragmentManager, String unp, HashMap<String, BackendlessCollection> dataForSet) {
        Log.d(TAG, "getInstance");
        unp_value = unp;
        SearchResultFragment searchFragment = (SearchResultFragment) fragmentManager.findFragmentByTag(SearchResultFragment.TAG);

        if (searchFragment == null) {
            searchFragment = new SearchResultFragment();
        }

        data = dataForSet;

        //TODO написать код получения данных из map и затем упаковать данные в Bundle
        //setBundles(dataForSet, searchFragment);
        //setBundles(data, searchFragment);

        return searchFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);
        mBadCompanies = (TextView) view.findViewById(R.id.tv_badCompanies);
        mDisputes = (TextView) view.findViewById(R.id.tv_disputes);
        mUnp = (TextView) view.findViewById(R.id.tv_unp_value);
        mUnp.setText(unp_value);

        //TODO Здесь написать код получения данных из Bundle и вывода во view
        //Вариант с Bundle
/*        Bundle bundle = getArguments();
        if (bundle != null) {
            int badCompaniesCount = bundle.getInt(BAD_COMPANIES_COUNT);
            int disputesCount = bundle.getInt(DISPUTES_COUNT);
            if (badCompaniesCount == 0) {
                mBadCompanies.setText("не вкл.");
            } else {
                mBadCompanies.setText("вкл. >>");
                mBadCompanies.setTextColor(Color.RED);
            }
            if (disputesCount>0) {
                mDisputes.setText(String.valueOf(disputesCount) + ">>");
                mBadCompanies.setTextColor(Color.RED);
            } else {
                mDisputes.setText(String.valueOf(disputesCount));
            }
        }*/

        //Вариант с получением данных из объектов

        if (data != null) {
            //Выводим в TextView информацию о наличии/отсутствии организации в Реестре лжеструктур,
            //а также о количестве имеющихся записей по данной организации в Базе судебных дел
            setRecordsQuantity();
        }

        return view;
    }

    private void setRecordsQuantity() {
        int badCompaniesCount = data.get("BadCompanies").getData().size();
        int disputesCount = data.get("Disputes").getData().size();
        if (badCompaniesCount == 1) {
            mBadCompanies.setText("вкл. >>");
            mBadCompanies.setTextColor(Color.RED);
        }
        if (disputesCount>0) {
            mDisputes.setText(String.valueOf(disputesCount) + ">>");
            mDisputes.setTextColor(Color.RED);
        }
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }

/*    private static void setBundles(HashMap<String, BackendlessCollection> dataForSet, SearchResultFragment searchFragment) {
        Bundle bundle = new Bundle();
        int badCompaniesCount = dataForSet.get("BadCompanies").getData().size();
        int disputesCount = dataForSet.get("Disputes").getData().size();
        bundle.putInt(BAD_COMPANIES_COUNT, badCompaniesCount);
        bundle.putInt(DISPUTES_COUNT, disputesCount);
        searchFragment.setArguments(bundle);
    }*/

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
}
