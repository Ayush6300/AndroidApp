package com.example.med_assist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag_heart extends Fragment {

    Spinner heart1, heart2, heart3, heart4, heart5, heart6;

    public frag_heart(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_heart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        heart1 = view.findViewById(R.id.spinheart1);
       heart2 =  view.findViewById(R.id.spinheart2);
        heart3 = view.findViewById(R.id.spinheart3);
        heart4 = view.findViewById(R.id.spinheart4);
        heart5 = view.findViewById(R.id.spinheart5);
        heart6 = view.findViewById(R.id.spinheart6);

        ArrayAdapter<CharSequence> adapter_heart1 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart1, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_heart2 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart2, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_heart3 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart3, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_heart4 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart4, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_heart5 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart5, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_heart6 = ArrayAdapter.createFromResource(getContext(),
                R.array.heart6, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_heart1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_heart2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_heart3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_heart4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_heart5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_heart6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        heart1.setAdapter(adapter_heart1);
        heart2.setAdapter(adapter_heart2);
        heart3.setAdapter(adapter_heart3);
        heart4.setAdapter(adapter_heart4);
        heart5.setAdapter(adapter_heart5);
        heart6.setAdapter(adapter_heart6);
    }

}
