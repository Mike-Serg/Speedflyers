package com.example.speedflyers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TutorialPage extends Fragment {

    private int pageNumber;


    public static TutorialPage newInstance(int page) {
        TutorialPage fragment = new TutorialPage();
        Bundle args = new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }


    public TutorialPage() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutorials_page, container, false);

        TextView pageText = view.findViewById(R.id.displayText);
        ImageView pageImage = view.findViewById(R.id.imageView);

        fillFragmentPage(pageText, pageImage);
        return view;
    }

    //Заполнение ViewImage и TextView на странице туторила, согласно номеру страницы
    private void fillFragmentPage(TextView pageText, ImageView pageImage) {
        switch (pageNumber){
            case 0:{
                pageImage.setImageResource(R.drawable.logo);
                pageText.setText(R.string.tutorialLogo);
                break;
            }
            case 1:{
                pageImage.setImageResource(R.drawable.speedflying_sites);
                pageText.setText(R.string.tutorialSpeedflyingSites);
                break;
            }
            case 2:{
                pageImage.setImageResource(R.drawable.launch_conditions);
                pageText.setText(R.string.tutorialLaunchCondition);
                break;
            }
            case 3:{
                pageImage.setImageResource(R.drawable.lines_landing);
                pageText.setText(R.string.tutorialLinesLandings);
                break;
            }
        }
    }

}