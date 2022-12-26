package com.nik.igurucode.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nik.igurucode.FragmentState.FragmentState;
import com.nik.igurucode.R;

public class HomeActivity extends AppNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        openNewsFragement(FragmentState.REPLACE);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int i = getSupportFragmentManager().getBackStackEntryCount();
        if (i > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
//            ExitFragmentDialog exitFragmentDialog = ExitFragmentDialog.newInstance();
//            exitFragmentDialog.show(getSupportFragmentManager(), exitFragmentDialog.getClass().getSimpleName());
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}