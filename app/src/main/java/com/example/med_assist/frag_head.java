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

public class frag_head extends Fragment {

    Spinner head1, head2, head3, head4, head5, head6, head7, head8, head9, head10;

    public frag_head() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_head, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        head1 = view.findViewById(R.id.spinHead1);
        head2 = view.findViewById(R.id.spinHead2);
        head3 = view.findViewById(R.id.spinHead3);
        head4 = view.findViewById(R.id.spinHead4);
        head5 = view.findViewById(R.id.spinHead5);
        head6 = view.findViewById(R.id.spinHead6);
        head7 = view.findViewById(R.id.spinHead7);
        head8 = view.findViewById(R.id.spinHead8);
        head9 = view.findViewById(R.id.spinHead9);
        head10 = view.findViewById(R.id.spinHead10);


        ArrayAdapter<CharSequence> adapter_head1 = ArrayAdapter.createFromResource(getContext(),
                R.array.head1, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_head1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        head1.setAdapter(adapter_head1);
    }
}
