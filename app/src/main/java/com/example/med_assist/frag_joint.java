package com.example.med_assist;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class frag_joint extends Fragment {

    Spinner joint1, joint2, joint3, joint4, joint5, joint6, joint7, joint8;
    static TextView txt;
    String x;

    public frag_joint(String bundle) {
       x= bundle;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.frag_joint, container, false);

        txt = view.findViewById(R.id.session);
//        txt.setText(x);


        return view;

    }

    public void myFunction(String value, String name) {

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("SessionID", x)
                .add("name", name)
                .add("value", value)
                .build();

        Request request = new Request.Builder()
                .url("https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name="+name + "&value="+value+"&SessionID="+x)
                .post(formBody)
                .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Toast.makeText(requireContext(),"successful" + value, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        joint1 = view.findViewById(R.id.spinjoint1);
        joint2 = view.findViewById(R.id.spinjoint2);
        joint3 = view.findViewById(R.id.spinjoint3);
        joint4 = view.findViewById(R.id.spinjoint4);
        joint5 = view.findViewById(R.id.spinjoint5);
        joint6 = view.findViewById(R.id.spinjoint6);
        joint7 = view.findViewById(R.id.spinjoint7);
        joint8 = view.findViewById(R.id.spinjoint8);




        ArrayAdapter<CharSequence> adapter_joint1 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint1, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint2 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint2, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint3 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint3, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint4 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint4, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint5 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint5, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint6 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint6, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint7 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint7, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_joint8 = ArrayAdapter.createFromResource(getContext(),
                R.array.joint8, android.R.layout.simple_spinner_item);

        adapter_joint1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_joint8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        joint1.setAdapter(adapter_joint1);
        joint2.setAdapter(adapter_joint2);
        joint3.setAdapter(adapter_joint3);
        joint4.setAdapter(adapter_joint4);
        joint5.setAdapter(adapter_joint5);
        joint6.setAdapter(adapter_joint6);
        joint7.setAdapter(adapter_joint7);
        joint8.setAdapter(adapter_joint8);


        joint1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction("3", "BoneLocPain");

                // Perform actions based on the selected item

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();

            }
        });



        joint2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();

                    myFunction("3", "JointsPain");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();


            }
        });

        joint3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "BoneGenPain");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();


            }
        });

        joint4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "MuscleGenPain");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();

            }
        });

        joint5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "GoutyRosPain");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();

            }
        });

        joint6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }
                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "GoutyRosPainProgression");


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();

            }
        });

        joint7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }
                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "SpinePain");


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();

            }
        });

        joint8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }
                String selectedItem = parent.getItemAtPosition(i).toString();

                myFunction(selectedItem, "TraumaToToesWithNoSkinBrake");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show();
            }
        });
        joint1.setSelection(-1);
        joint2.setSelection(-1);
        joint3.setSelection(-1);
        joint4.setSelection(-1);
        joint5.setSelection(-1);
        joint6.setSelection(-1);
        joint7.setSelection(-1);
        joint8.setSelection(-1);


    }

}
