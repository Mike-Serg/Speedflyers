package com.example.speedflyers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        TutorialFragment.onEventLoginFragment,
        LoginFragment.onEventRegistrationFragment,
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

        //Активация фрагмента Login
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activeMain, LoginFragment.class, null)
                .commit();

        //Если приложение запущено в первый раз
        if (firstStart) {
            //Активация туториала
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activeMain, TutorialFragment.class, null)
                    .addToBackStack(null)
                    .commit();

            /*
            TODO: раскоментировать код для записи признака, о том, что приложение запускалось
            //Запись признака, что приложение уже запускалось
            SharedPreferences.Editor editorSP = sharedPreferences.edit();
            editorSP.putBoolean(FIRST_START, false);
            editorSP.apply();
             */
        }
    }

    //Интерфейс для TutorialFragment
    @Override
    public void openLoginFragment() {
        getSupportFragmentManager().popBackStack();
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