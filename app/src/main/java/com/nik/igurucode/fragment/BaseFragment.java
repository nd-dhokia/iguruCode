package com.nik.igurucode.fragment;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.nik.igurucode.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment {

    HomeActivity homeActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof HomeActivity) {
            homeActivity = (HomeActivity) context;
        }
    }

    public List<String> getStringList(int norecord, String DisplayContent) {
        List<String> datalist = new ArrayList<>();
        for (int i = 1; i <= norecord; i++) {
            datalist.add(DisplayContent);
        }
        return datalist;
    }

}
