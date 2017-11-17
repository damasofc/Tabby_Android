package com.damasofc.tabby.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.damasofc.tabby.Adapters.MyAdapter;
import com.damasofc.tabby.Models.Country;
import com.damasofc.tabby.Models.Person;
import com.damasofc.tabby.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountriesFragment extends Fragment {
    public static List<Person> persons;
    ListView listView;
    private MyAdapter adapter;
    public CountriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        persons = new ArrayList<Person>();
        persons.add(new Person("Damaso Fernandez",new Country("Honduras","US")));
        adapter = new MyAdapter(getContext(),R.layout.list_item,persons);
        listView.setAdapter(adapter);
        return view;
    }

}
