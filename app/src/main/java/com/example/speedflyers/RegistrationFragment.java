package com.example.speedflyers;

import android.content.Context;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationFragment extends Fragment {

    //Интерфейс для открытия фрагмента Registration
    public interface onEventTermsConditionsFragment {
        void openTermsConditionsFragment();
    }

    private onEventTermsConditionsFragment eventTermsConditionsFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            eventTermsConditionsFragment = (RegistrationFragment.onEventTermsConditionsFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс onEventTermsConditionsFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        //обработка нажатия кнопки "buttonTermsConditions"
        Button buttonTermsConditions = view.findViewById(R.id.buttonTermsConditions);
        buttonTermsConditions.setOnClickListener(v -> eventTermsConditionsFragment.openTermsConditionsFragment());

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        //Спрятать пароли за звезды
        TextInputEditText passwdEditText =requireView().findViewById(R.id.passwd_EditText);
        TextInputEditText confirmPasswdEditText =requireView().findViewById(R.id.confirm_passwd_EditText);
        passwdEditText.setTransformationMethod(new PasswordTransformationMethod());
        confirmPasswdEditText.setTransformationMethod(new PasswordTransformationMethod());
    }

}
