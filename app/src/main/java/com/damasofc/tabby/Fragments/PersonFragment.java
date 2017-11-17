package com.damasofc.tabby.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.damasofc.tabby.Models.Country;
import com.damasofc.tabby.Models.Person;
import com.damasofc.tabby.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    EditText name;
    Spinner country;
    Button create;
    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        name = (EditText) view.findViewById(R.id.personName);
        country = (Spinner) view.findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.countries,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);
        create = (Button) view.findViewById(R.id.btn_Create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String perName = name.getText().toString();
                String countryPer =  country.getSelectedItem().toString();
                String code = "";
                switch (countryPer){
                    case "Honduras":
                        code = "HN";
                        break;
                    case "USA":
                        code = "US";
                        break;
                    case "Mexico":
                        code = "MX";
                        break;
                    case "Costa Rica":
                        code = "CR";
                        break;
                    case "Espana":
                        code = "ES";
                        break;
                }
                Person newPerson = new Person(perName,new Country(countryPer,code));
                CountriesFragment.persons.add(newPerson);
                Toast.makeText(getContext(),"Nueva persona creada",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
