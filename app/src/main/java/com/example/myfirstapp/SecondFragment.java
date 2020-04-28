package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class SecondFragment extends Fragment {

    TextView headerTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View fragmentSecondLayout = inflater.inflate(R.layout.fragment_second, container, false);
        headerTextView = fragmentSecondLayout.findViewById(R.id.textview_header);
        return fragmentSecondLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Integer currentCount = getArguments().getInt("currentCount");
        String headerString = getString(R.string.random_heading, currentCount);
        headerTextView.setText(headerString);

        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (currentCount > 0) {
            randomNumber = random.nextInt(currentCount + 1);
        }

        TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        randomView.setText(randomNumber.toString());

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
