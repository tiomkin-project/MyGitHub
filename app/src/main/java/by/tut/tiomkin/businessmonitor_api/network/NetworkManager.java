package by.tut.tiomkin.businessmonitor_api.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.HashMap;

import by.tut.tiomkin.businessmonitor_api.MyApplication;
import by.tut.tiomkin.businessmonitor_api.network.data.BadCompanies;
import by.tut.tiomkin.businessmonitor_api.network.data.Disputes;
import by.tut.tiomkin.businessmonitor_api.network.data.crud.common.Defaults;

public class NetworkManager {

    private static final String TAG = NetworkManager.class.getSimpleName();
    private static NetworkManager networkManager = new NetworkManager();
    //private static HashMap<Integer, BackendlessCollection> data = new HashMap<>();
    private static HashMap<Integer, Integer> data = new HashMap<>();

    public static NetworkManager getInstance() {
        Log.d(TAG, "getInstance()");
        return networkManager;

    }

    //public HashMap<Integer, BackendlessCollection> search(String unp) {
    public HashMap<Integer, Integer> search(String unp) {
        Log.d(TAG, "search() unp = " + unp);

        //HashMap<Integer, BackendlessCollection> data = new HashMap<>();
        String where = "unp = " + unp;
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setWhereClause(where);
        Backendless.initApp(MyApplication.getAppContext(), Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);

        //Вариант синхронный
        //Здесь ищем по базе лжеструктур
        BackendlessCollection<BadCompanies> badCompaniesList = Backendless.Persistence.of(BadCompanies.class).find(query);
        Log.d(TAG, "badCompaniesList.size = " + badCompaniesList.getData().size());

        //Вариант асинхронный
        //Здесь ищем по базе лжеструктур
        /*Backendless.Persistence.of(BadCompanies.class).find(query, new AsyncCallback<BackendlessCollection<BadCompanies>>() {
            @Override
            public void handleResponse(BackendlessCollection<BadCompanies> collection) {
                Log.d("BadCompanies", "collection.getData().size()) = " + collection.getData().size());
                data.put(0, 0);

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.d(TAG, "handleFault code = " + backendlessFault.getCode());
                Log.d(TAG, "handleFault message = " + backendlessFault.getMessage());
                Log.d(TAG, "handleFault detail = " + backendlessFault.getDetail());


            }
        });*/


        //Здесь ищем по базе судебных дел
        /*Backendless.Persistence.of(Disputes.class).find(query, new AsyncCallback<BackendlessCollection<Disputes>>() {
            @Override
            public void handleResponse(BackendlessCollection<Disputes> disputesBackendlessCollection) {
                Log.d("Disputes", "size()) = " + disputesBackendlessCollection.getData().size());
                //data.put(1, disputesBackendlessCollection);
                data.put(1, 1);
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.d(TAG, "Disputes handleFault = " + backendlessFault.getMessage());

            }
        });*/

        //BackendlessCollection<BadCompanies> company = data.get(0);

        Log.d(TAG, "data.get" + data.get(0));

        return data;

    }

    public boolean isOnline() {
        Log.d(TAG, "isOnline()");
        ConnectivityManager cm =
                (ConnectivityManager) MyApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}
