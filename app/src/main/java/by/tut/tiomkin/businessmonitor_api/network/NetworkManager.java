package by.tut.tiomkin.businessmonitor_api.network;

import android.util.Log;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import by.tut.tiomkin.businessmonitor_api.MyApplication;
import by.tut.tiomkin.businessmonitor_api.network.data.BadCompanies;
import by.tut.tiomkin.businessmonitor_api.network.data.crud.common.Defaults;

public class NetworkManager {

    private static final String TAG = NetworkManager.class.getSimpleName();
    private static NetworkManager networkManager = new NetworkManager();

    public static NetworkManager getInstance() {
        return networkManager;

    }

    public void search(String unp) {

        String where = "unp = " + unp;
        BackendlessDataQuery query = new BackendlessDataQuery();
        query.setWhereClause(where);
        Backendless.initApp(MyApplication.getAppContext(), Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);
        //Работает. Вариант синхронный
        /*BackendlessCollection<BadCompanies> result = Backendless.Persistence.of(BadCompanies.class).find(query);
        Log.d(TAG, "search() --> result.getData().size() = " + result.getData().size());*/

        //Вариант асинхронный
        Backendless.Persistence.of(BadCompanies.class).find(query, new AsyncCallback<BackendlessCollection<BadCompanies>>() {
            @Override
            public void handleResponse(BackendlessCollection<BadCompanies> collection) {
                Log.d("Async", "collection.getData().size()) = " + collection.getData().size());
                int recordsQuantity = collection.getData().size();
                if (recordsQuantity>0) {

                    Toast.makeText(MyApplication.getAppContext(), "Организация включена в реестр", Toast.LENGTH_SHORT).show();
                } else if (recordsQuantity == 0) {
                    Toast.makeText(MyApplication.getAppContext(), "Организация не включена в реестр", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        });

    }
}
