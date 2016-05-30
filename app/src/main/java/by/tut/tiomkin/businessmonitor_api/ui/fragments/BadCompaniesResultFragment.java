package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.BackendlessCollection;

import java.util.HashMap;

import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.network.data.BadCompanies;

public class BadCompaniesResultFragment extends BaseFragment {

    private static final String TAG = BadCompaniesResultFragment.class.getSimpleName();
    private static BadCompanies badCompany;
    TextView mUnp, mName, mDate, mReason;

    public static BadCompaniesResultFragment getInstance(FragmentManager fragmentManager, Object data) {
        Log.d(TAG, "getInstance");

        BadCompaniesResultFragment badCompaniesResultFragment = (BadCompaniesResultFragment) fragmentManager.findFragmentByTag(BadCompaniesResultFragment.TAG);

        badCompany = (BadCompanies)data;

        if (badCompaniesResultFragment == null) {
            badCompaniesResultFragment = new BadCompaniesResultFragment();
        }

        return badCompaniesResultFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_badcompanies_result, container, false);
        mUnp = (TextView) view.findViewById(R.id.details_unp_value);
        mName = (TextView) view.findViewById(R.id.details_companyname);
        mDate = (TextView) view.findViewById(R.id.details_date);
        mReason = (TextView) view.findViewById(R.id.details_reason);
        //Выводим в TextView подробную информацию о включении организации в Реестр лжеструктур
        setData();
        return view;
    }

    private void setData() {
        mUnp.setText(badCompany.getUnp());
        mName.setText(badCompany.getName());
        mDate.setText(badCompany.getDate_included());
        mReason.setText(badCompany.getArticle());
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }
}
