package com.example.android_w17_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate view.
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView textView = view.findViewById(R.id.detailTextview);

        String[] detailItems = {"A towel.",
        "Wrong.",
        "Wet."};

        Bundle bundle = this.getArguments(); //get the data from the other fragment

        int data = bundle.getInt("key"); //actually getting the data/position/index of what was pressed

        textView.setText(detailItems[data]); //Setting textview to corresponding string from the array


        // Inflate the layout for this fragment
        return view;
    }
}
