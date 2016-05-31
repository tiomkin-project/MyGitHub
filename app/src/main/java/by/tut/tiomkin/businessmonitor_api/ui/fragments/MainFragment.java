package by.tut.tiomkin.businessmonitor_api.ui.fragments;


import android.content.Context;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.backendless.BackendlessCollection;

import java.util.HashMap;

import by.tut.tiomkin.businessmonitor_api.MyApplication;
import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.constants.Defaults;
import by.tut.tiomkin.businessmonitor_api.enums.FragmentAnim;
import by.tut.tiomkin.businessmonitor_api.listeners.MyListener;
import by.tut.tiomkin.businessmonitor_api.network.NetworkManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    Button mFind;
    EditText mUnp;
    ProgressBar mProgressBar;
    private MyListener mMyListener;
    private NetworkManager networkManager = NetworkManager.getInstance();


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

        //Таким образом всё работает
        mFind = (Button) view.findViewById(R.id.btn_search);
        mUnp = (EditText) view.findViewById(R.id.et_unp);
        mProgressBar = (ProgressBar) view.findViewById(R.id.pb_loading);

        Log.d(TAG, "String.valueOf(mUnp.getText()) = " + String.valueOf(mUnp.getText()));
        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!networkManager.isOnline()) {
                    Toast.makeText(MyApplication.getAppContext(),
                            "Нет соединения с интернетом!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    search(String.valueOf(mUnp.getText()));
                }

            }
        });
        Log.d(TAG, "After search(mUnp)");
        return view;
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
    public String getFragmentTag() {
        return TAG;
    }

    private class AsyncDataLoader extends AsyncTask<String, Void, HashMap<String, BackendlessCollection>> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected HashMap<String, BackendlessCollection> doInBackground(String... params) {

            Log.d(TAG, "doInBackground params[0]" + params[0]);
            HashMap<String, BackendlessCollection> dataReceived = networkManager.search(params[0]);

            return dataReceived;
        }

        @Override
        protected void onPostExecute(HashMap<String, BackendlessCollection> dataReceived) {
            mProgressBar.setVisibility(View.GONE);
            String unp_value = String.valueOf(mUnp.getText());
            mMyListener.switchFragment(SearchResultFragment.getInstance(getFragmentManager(), unp_value, dataReceived),
                    true,
                    false,
                    FragmentAnim.RIGHT_TO_LEFT);
        }
    }

    private void search(String mUnp) {
        Log.d(TAG, "search()");

        new AsyncDataLoader().execute(mUnp);

        /*mProgressBar.setVisibility(View.VISIBLE);
        //HashMap для хранения данных, полученных из метода search.
        //Под ключом 0 хранятся найденные объекты из таблицы BadCompanies
        //Под ключом 1 хранятся найденные объекты из таблицы Disputes
        //HashMap<Integer, BackendlessCollection> dataReceived;
        HashMap<Integer, Integer> dataReceived;

        Log.d(TAG, "search() mUnp.getText = " + mUnp.getText());

        //dataReceived = NetworkManager.getInstance().search(String.valueOf(mUnp.getText()));

        dataReceived = networkManager.search(String.valueOf(mUnp.getText()));
        //TODO обработать получени данных из search
        //Создаем HashMap с данными, которые получили в результате поиска, для передачи в SearchResultFragment
        //Под ключом 0 хранится количество записей в реестре лжеструктур
        //Под ключом 1 хранится количество записей в списке судебных дел


        HashMap<Integer, Integer> dataForSet = new HashMap<>();

        //Количество записей о компании в реесте лжеструктур. Может быть 0 или 1
        Log.d(TAG, "dataReceived.get(0)" + dataReceived.get(0));

        //int badCompaniesQuantity = dataReceived.get(0).getData().size();
        int badCompaniesQuantity = dataReceived.get(0);
        if (badCompaniesQuantity == 0) {
            dataForSet.put(0, 0);
        } else {
            dataForSet.put(0, 1);
        }

        //Количество записей о компании в списке судебных дел. Может быть 0 или неограниченное количество
        //int disputesQuantity = dataReceived.get(1).getData().size();
        int disputesQuantity = dataReceived.get(1);
        if (disputesQuantity == 0) {
            dataForSet.put(1, 0);
        } else {
            dataForSet.put(1, disputesQuantity);
        }

        mMyListener.switchFragment(SearchResultFragment.getInstance(getFragmentManager(), dataForSet),
                true,
                false,
                FragmentAnim.RIGHT_TO_LEFT);
        mProgressBar.setVisibility(View.GONE);*/


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mMyListener != null) mMyListener.setTitle(Defaults.MAIN_FRAGMENT_TITLE);
    }

}
