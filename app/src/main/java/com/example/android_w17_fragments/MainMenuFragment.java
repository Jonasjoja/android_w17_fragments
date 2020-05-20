package com.example.android_w17_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the view first
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        String[] menuItems = {"I am wet when drying. What am I?",
        "What word is always pronounced wrong?",
        "If you drop a yellow hat in the Red Sea, what does it become?"};

        ListView listView = view.findViewById(R.id.mainMenuListview); //assign local variable to the listview.

        //Creates arrayadapter to turn the array into something a listview can use.
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,menuItems);

        listView.setAdapter(listViewAdapter); //tells the listview to use the adapter

        //Onclick listener to do something when an item in the listview is clicked.
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //Pos tells index of item clicked on
               DetailFragment detailFragment = new DetailFragment();
               FragmentManager fragmentManager = getFragmentManager(); //fragmentmanager to be used to do the "transaction"

               Bundle bundle = new Bundle(); //a bundle to pass on something to the other fragment
               bundle.putInt("key",position); //I want to pass the position/index of the item clicked
               detailFragment.setArguments(bundle); //Actually passing it

               fragmentManager.beginTransaction().replace(R.id.container, detailFragment).commit(); //replace fragment
           }
       });

        // return the inflated view.
        return view;
    }
}
