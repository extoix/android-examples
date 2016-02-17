package com.extoix.example.arrayadapter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayAdapter<String> mArrayAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] sampleData = {
                "Test Data 1",
                "Test Data 2",
                "Test Data 3",
                "Test Data 4",
                "Test Data 5"
        };

        List<String> listData = new ArrayList<String>(Arrays.asList(sampleData));

        mArrayAdapter = new ArrayAdapter<String>(
                getActivity(), // context
                R.layout.list_item, // id of the list_item
                R.id.list_item_textview, // id of the textview that will be populated with data
                listData // list of data
        );

        ListView listView = (ListView)rootView.findViewById(R.id.listview);
        listView.setAdapter(mArrayAdapter);

        return rootView;
    }
}
