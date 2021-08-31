package com.example.speedflyers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

/*
TODO: переделать порядок запуска фрагментов
первый фрагмент Login, затем если приложение запущено в первые, то показать туториал,
с возможностью возврата через кнопку назад на фрагмен Login.
Фрагмент регистрации так же должен возвращать на Login при нажатии кнопки возврат.
 */


public class MainActivity extends AppCompatActivity implements
        TutorialFragment.onEventLoginFragment, LoginFragment.onEventRegistrationFragment,
        RegistrationFragment.onEventTermsConditionsFragment {

    //Константы для sharedPreference
    private static final String SF_SETTINGS = "SF_Settings";
    private static final String FIRST_START = "First_Start";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Чтение данных о первом запуске приложения
        SharedPreferences sharedPreferences = getSharedPreferences(SF_SETTINGS, MODE_PRIVATE);
        boolean firstStart = sharedPreferences.getBoolean(FIRST_START, true);

        if (firstStart) {
            //Активация туториала при первом запуске приложения
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activeMain, TutorialFragment.class, null)
                    .commit();

            //Запись признака, что приложение уже запускалось

            /*
            TODO: раскоментировать строку для записи признака
            SharedPreferences.Editor editorSP = sharedPreferences.edit();
            editorSP.putBoolean(FIRST_START, false);
            editorSP.apply();
             */
        } else {
            //Активация фрагмента Login, если приложение запускается не в первый раз
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activeMain, LoginFragment.class, null)
                    .commit();
        }
    }

    //Интерфейс для TutorialFragment
    @Override
    public void openLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activeMain, LoginFragment.class, null)
                .commit();
    }

    //Интерфейс для LoginFragment
    @Override
    public void openRegistrationFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activeMain, RegistrationFragment.class, null)
                .addToBackStack(null)
                .commit();
    }

    //Интерфейс для RegistrationFragment
    @Override
    public void openTermsConditionsFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activeMain, TermsConditions.class, null)
                .addToBackStack(null)
                .commit();
    }
}