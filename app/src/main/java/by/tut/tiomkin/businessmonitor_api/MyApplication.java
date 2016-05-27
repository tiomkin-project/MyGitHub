package by.tut.tiomkin.businessmonitor_api;

import android.app.Application;
import android.content.Context;
import android.util.Log;


public class MyApplication extends Application {

    private static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication myApplication;
    private static Context context;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        MyApplication.context = getApplicationContext();
        Log.d(TAG, "onCreate()");

    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
