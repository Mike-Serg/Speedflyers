package com.example.speedflyers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TutorialAdapter extends FragmentStateAdapter {

    public TutorialAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return(TutorialPage.newInstance(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}