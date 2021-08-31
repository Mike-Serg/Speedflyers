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


public class LoginFragment extends Fragment {

    //Интерфейс для открытия фрагмента Registration
    public interface onEventRegistrationFragment {
        void openRegistrationFragment();
    }

    private onEventRegistrationFragment eventRegistrationFragmentListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            eventRegistrationFragmentListener = (onEventRegistrationFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс onEventLoginFragment");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        //Обработка нажатия кнопки "buttonRegistration"
        Button buttonSkip = view.findViewById(R.id.buttonRegistration);
        buttonSkip.setOnClickListener(v -> eventRegistrationFragmentListener.openRegistrationFragment());

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        //Спрятать пароль за звезды
        TextInputEditText passwordEditText =requireView().findViewById(R.id.password_EditText);
        passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
    }

}
