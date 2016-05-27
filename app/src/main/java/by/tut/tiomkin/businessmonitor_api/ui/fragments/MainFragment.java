package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;

import by.tut.tiomkin.businessmonitor_api.MyApplication;
import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.listeners.MyToolbarListener;
import by.tut.tiomkin.businessmonitor_api.network.NetworkManager;
import by.tut.tiomkin.businessmonitor_api.network.data.BadCompanies;
import by.tut.tiomkin.businessmonitor_api.network.data.crud.common.Defaults;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    Button mFind;
    EditText mUnp;
    ProgressBar mProgressBar;
    private MyToolbarListener mToolbarListener;


    private static final String TAG = MainFragment.class.getSimpleName();


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment getInstance(FragmentManager fragmentManager) {
        Log.d(TAG, "getInstance");
        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentByTag(MainFragment.TAG);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }

        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_main, container, false);
       /* mFind = (Button) view.findViewById(R.id.btn_search);
        mUnp = (EditText) view.findViewById(R.id.et_unp);
        mProgressBar = (ProgressBar) view.findViewById(R.id.pb_loading);

        Log.d(TAG, "String.valueOf(mUnp.getText()) = " + String.valueOf(mUnp.getText()));
        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(mUnp);

            }
        });*/
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MyToolbarListener) {
            mToolbarListener = (MyToolbarListener) context;
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onDetach() {
        mToolbarListener = null;
        setHasOptionsMenu(false);
        super.onDetach();
    }

    @Override
    public String getFragmentTag() {
        return TAG;
    }

    private void search(EditText mUnp) {
        mProgressBar.setVisibility(View.VISIBLE);
        NetworkManager.getInstance().search(String.valueOf(mUnp.getText()));

    }
}
