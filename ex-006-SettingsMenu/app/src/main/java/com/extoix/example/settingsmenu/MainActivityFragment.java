package com.extoix.example.settingsmenu;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        TextView textViewPreference = (TextView)rootView.findViewById(R.id.textview_preference);
        String prefValue = sharedPrefs.getString(getString(R.string.pref_key), getString(R.string.pref_default));
        textViewPreference.setText(prefValue);

        TextView textViewTempUnits = (TextView)rootView.findViewById(R.id.textview_tempunits);
        String prefValueTempUnit = sharedPrefs.getString(getString(R.string.pref_units_key), getString(R.string.pref_units_metric));
        textViewTempUnits.setText(prefValueTempUnit);

        return rootView;
    }

}
