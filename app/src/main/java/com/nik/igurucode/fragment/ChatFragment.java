package com.nik.igurucode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nik.igurucode.FragmentState.FragmentState;
import com.nik.igurucode.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends BaseFragment {
    Unbinder unbinder;

    @BindView(R.id.rbNews)
    RadioButton rbNews;
    @BindView(R.id.rbRoster)
    RadioButton rbRoster;
    @BindView(R.id.rbChat)
    RadioButton rbChat;
    @BindView(R.id.rbMatches)
    RadioButton rbMatches;
    @BindView(R.id.rbVideos)
    RadioButton rbVideos;
    @BindView(R.id.radioGrp)
    RadioGroup radioGrp;
    @BindView(R.id.llBottonBar)
    LinearLayout llBottonBar;

    public ChatFragment() {
        // Required empty public constructor
    }


    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rbChat.setChecked(true);
    }

    @OnClick({R.id.rbNews, R.id.rbRoster, R.id.rbChat, R.id.rbMatches, R.id.rbVideos})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbNews:
                homeActivity.openNewsFragement(FragmentState.REPLACE);
                break;
            case R.id.rbRoster:
                homeActivity.openRosterFragment(FragmentState.REPLACE);
                break;
            case R.id.rbChat:
                break;
            case R.id.rbMatches:
                homeActivity.openMatchesFragment(FragmentState.REPLACE);
                break;
            case R.id.rbVideos:
                homeActivity.openVideoFragment(FragmentState.REPLACE);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}