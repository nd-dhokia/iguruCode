package com.nik.igurucode.activity;

import androidx.fragment.app.FragmentManager;

import com.nik.igurucode.FragmentState.FragmentState;
import com.nik.igurucode.fragment.ChatFragment;
import com.nik.igurucode.fragment.MatchesFragment;
import com.nik.igurucode.fragment.NewsFragment;
import com.nik.igurucode.fragment.RosterFragment;
import com.nik.igurucode.fragment.VideoFragment;
import com.nik.igurucode.listener.iAppNevigator;

public class AppNavigationActivity extends BaseActivity implements iAppNevigator {
    @Override
    public void openNewsFragement(FragmentState fragmentState) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentChange(NewsFragment.newInstance(), fragmentState);
    }

    @Override
    public void openRosterFragment(FragmentState fragmentState) {
        fragmentChange(RosterFragment.newInstance(), fragmentState);
    }

    @Override
    public void openChatFragment(FragmentState fragmentState) {
        fragmentChange(ChatFragment.newInstance(), fragmentState);
    }

    @Override
    public void openMatchesFragment(FragmentState fragmentState) {
        fragmentChange(MatchesFragment.newInstance(), fragmentState);
    }

    @Override
    public void openVideoFragment(FragmentState fragmentState) {
        fragmentChange(VideoFragment.newInstance(), fragmentState);
    }
}
