package com.nik.igurucode.listener;

import com.nik.igurucode.FragmentState.FragmentState;

public interface iAppNevigator {

    void openNewsFragement(FragmentState fragmentState);

    void openRosterFragment(FragmentState fragmentState);

    void openChatFragment(FragmentState fragmentState);

    void openMatchesFragment(FragmentState fragmentState);

    void openVideoFragment(FragmentState fragmentState);


}
