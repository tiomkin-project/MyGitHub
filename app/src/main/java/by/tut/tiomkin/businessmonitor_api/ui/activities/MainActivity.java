package by.tut.tiomkin.businessmonitor_api.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;

import by.tut.tiomkin.businessmonitor_api.MyApplication;
import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.enums.FragmentAnim;
import by.tut.tiomkin.businessmonitor_api.network.NetworkManager;
import by.tut.tiomkin.businessmonitor_api.network.data.BadCompanies;
import by.tut.tiomkin.businessmonitor_api.network.data.crud.common.Defaults;
import by.tut.tiomkin.businessmonitor_api.ui.fragments.BaseFragment;
import by.tut.tiomkin.businessmonitor_api.ui.fragments.MainFragment;
import by.tut.tiomkin.businessmonitor_api.listeners.MyToolbarListener;

public class MainActivity extends BaseActivity implements MyToolbarListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private NetworkManager networkManager = NetworkManager.getInstance();

    TextView mTitleText;
    EditText mUnp;
    Button mFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        showFragment(MainFragment.getInstance(getSupportFragmentManager()), true, false, FragmentAnim.NONE);
        mFind = (Button) findViewById(R.id.btn_search);
        mUnp = (EditText) findViewById(R.id.et_unp);
        Log.d(TAG, "mFind = " + mFind.getText());
        if (mFind != null) {
            mFind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick() --> String.valueOf(mUnp.getText()) = " + String.valueOf(mUnp.getText()));
                    NetworkManager.getInstance().search(String.valueOf(mUnp.getText()));
                }
            });
        }
    }


    private void initToolbar() {
        Log.d(TAG, "initToolbar");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTitleText = (TextView) toolbar.findViewById(R.id.tv_title);

        toolbar.setNavigationIcon(R.drawable.ic_dehaze_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello!!", Toast.LENGTH_SHORT).show();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void switchFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim) {
        Log.d(TAG, "switchFragment");
        showFragment(fragment, addToBackStack, clearBackStack, fragmentAnim);

    }

    private void showFragment(BaseFragment fragment, boolean addToBackStack, boolean clearBackStack, FragmentAnim fragmentAnim) {
        Log.d(TAG, "showFragment");
        if (clearBackStack) {
            while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentAnim == FragmentAnim.RIGHT_TO_LEFT) {
            transaction.setCustomAnimations(
                    R.anim.fragment_enter_from_right,
                    R.anim.fragment_exit_to_left,
                    R.anim.fragment_enter_from_left,
                    R.anim.fragment_exit_to_right);
        }
        //transaction.replace(R.id.main_container, fragment, fragment.getFragmentTag());
        transaction.replace(R.id.main_container, fragment, fragment.getFragmentTag());
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
