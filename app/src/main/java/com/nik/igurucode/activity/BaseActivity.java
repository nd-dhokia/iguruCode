package com.nik.igurucode.activity;

import android.app.ProgressDialog;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.nik.igurucode.FragmentState.FragmentState;
import com.nik.igurucode.R;

public class BaseActivity extends AppCompatActivity {
    ProgressDialog dialog;


    void fragmentChange(Fragment fragment, FragmentState fragmentState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentState == FragmentState.ADD) {
            transaction.add(R.id.fragment_container, fragment);
        } else {
            transaction.replace(R.id.fragment_container, fragment);
        }
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commitAllowingStateLoss();
    }


    public void showProgressDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setMessage(getString(R.string.loading));
            dialog.setCancelable(false);
            dialog.show();
        } else {
            dialog.setMessage(getString(R.string.loading));
            dialog.show();
        }
    }

    public void hideProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void showSnackBar(View view, String msg) {
        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
