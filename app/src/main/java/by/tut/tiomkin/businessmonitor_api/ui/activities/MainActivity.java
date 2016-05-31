package by.tut.tiomkin.businessmonitor_api.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import by.tut.tiomkin.businessmonitor_api.R;
import by.tut.tiomkin.businessmonitor_api.enums.FragmentAnim;
import by.tut.tiomkin.businessmonitor_api.ui.fragments.BaseFragment;
import by.tut.tiomkin.businessmonitor_api.ui.fragments.MainFragment;
import by.tut.tiomkin.businessmonitor_api.listeners.MyListener;

public class MainActivity extends BaseActivity implements MyListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        showFragment(MainFragment.getInstance(getSupportFragmentManager()), false, false, FragmentAnim.NONE);

    }


    private void initToolbar() {
        Log.d(TAG, "initToolbar");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            mTitleText = (TextView) toolbar.findViewById(R.id.tv_title);
            toolbar.setNavigationIcon(R.drawable.ic_dehaze_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Hello!!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    //Метод смены фрагмента
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

        transaction.replace(R.id.main_container, fragment, fragment.getFragmentTag());
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    //Устанавливаем текст в тулбаре

    @Override
    public void setTitle(CharSequence title) {
        
        mTitleText.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        mTitleText.setText(titleId);
    }
}
