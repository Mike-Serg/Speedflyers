package com.example.speedflyers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TutorialFragment extends Fragment {

    //Интерфейс для открытия фрагмента Login
    public interface onEventLoginFragment {
        void openLoginFragment();
    }

    private onEventLoginFragment eventLoginFragmentListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            eventLoginFragmentListener = (onEventLoginFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс onEventLoginFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

        //TODO: Подумать как отображать страницы туториала без создания фрагментов для каждой страницы.
        //Отрисовка фрагментов внутри ViewPager2
        ViewPager2 pager = view.findViewById(R.id.tutorial_pager);
        FragmentStateAdapter pageAdapter = new TutorialAdapter(this);
        pager.setAdapter(pageAdapter);

        //Добавление точек отображения текущей позиции во ViewPager2
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, pager, (tab, position) -> {});
        tabLayoutMediator.attach();

        //Обработка нажатия кнопки "buttonSkip"
        Button buttonSkip = view.findViewById(R.id.buttonSkip);
        buttonSkip.setOnClickListener(v -> eventLoginFragmentListener.openLoginFragment());

        return view;
    }
}
