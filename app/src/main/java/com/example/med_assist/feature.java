package com.example.med_assist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http1.HeadersReader;

public class feature extends AppCompatActivity {

    private Button create, head, abdomen, throat, lb, ear, eyes, mouth, nose, chest, joint;
    private Button transfer, generate;

    private Spinner spinnerGender, spinnerCough, spinnerVomit, SpinnerSneezing;
    private EditText age, temperature, DBP, SBP, pulse;
    private Boolean Head = false, Abdomen = false, Throat = false, LB = false, Ear = false, Eyes = false, Mouth = false, Nose = false, Heart = false, Chest =false, Joint = false;

    List<String> selected = new ArrayList<>();

    String[] listContent = {
            "Age",
            "Gender",
            "Body Temperature",
            "Pulse Rate",
            "Systolic Blood Pressure",
            "Diastolic Blood Pressure",
            "Sneezing",
            "Nausea",
            "Vomiting"

    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        ListView myList = findViewById(R.id.featuresList);
        create = findViewById(R.id.create);
        head = findViewById(R.id.head);
        abdomen = findViewById(R.id.abdomen);
        throat = findViewById(R.id.throat);
        lb = findViewById(R.id.lowerback);
        ear = findViewById(R.id.ear);
        eyes = findViewById(R.id.eyes);
        mouth = findViewById(R.id.mouth);
        nose = findViewById(R.id.nose);
        chest = findViewById(R.id.chest);
        joint = findViewById(R.id.joints);


        transfer = findViewById(R.id.transfer_feature);
        generate = findViewById(R.id.generator);

        age = findViewById(R.id.spinner_age);
        temperature = findViewById(R.id.body_temp);
        spinnerGender = findViewById(R.id.spinner_gender);
        spinnerCough = findViewById(R.id.cough);
        spinnerVomit = findViewById(R.id.vomiting);
        SpinnerSneezing = findViewById(R.id.sneezing);

        Intent intent = getIntent();
        String sessionID = intent.getStringExtra("id");
//


        ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerGender.setAdapter(adapter_gender);

        ArrayAdapter<CharSequence> adapter_cough = ArrayAdapter.createFromResource(this,
                R.array.cough, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_cough.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerCough.setAdapter(adapter_cough);

        ArrayAdapter<CharSequence> adapter_vomit = ArrayAdapter.createFromResource(this,
                R.array.Vomiting, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_vomit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerVomit.setAdapter(adapter_vomit);

        ArrayAdapter<CharSequence> adapter_sneezing = ArrayAdapter.createFromResource(this,
                R.array.Sneezing, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_sneezing.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        SpinnerSneezing.setAdapter(adapter_sneezing);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, listContent);

        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myList.setAdapter(adapter);
//        getSupportActionBar().hide();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String selected = "";
                List<Integer> mylist = new ArrayList<Integer>();
                int cntChoice = myList.getCount();
                SparseBooleanArray sparseBooleanArray = myList.getCheckedItemPositions();


                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {
                        mylist.add(i);
                        selected += i + "\n"; //this is returning the index of the item selected
                    }
                }
//                List myList1 = new ArrayList();
                String saved = "row\n";
                for (int i = 0; i < 4; i++) {
                    if (mylist.contains(i)) {
                        saved += 1 + "\n";
                    } else {
                        saved += 0 + "\n";
                    }
                }
                String text = saved;
                FileOutputStream fos = null;

                FileInputStream fis = null;

                create.setBackgroundColor(Color.BLUE);
                Heart = true;


            }

        });

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                head.setBackgroundColor(Color.BLUE);
                Head = true;
            }
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chest.setBackgroundColor(Color.BLUE);
                Chest = true;
            }
        });

        joint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joint.setBackgroundColor(Color.BLUE);
                Joint = true;

            }
        });

        abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abdomen.setBackgroundColor(Color.BLUE);
                Abdomen = true;
            }
        });

        throat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throat.setBackgroundColor(Color.BLUE);
                Throat = true;
            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lb.setBackgroundColor(Color.BLUE);
                LB = true;
            }
        });

        ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ear.setBackgroundColor(Color.BLUE);
                Ear = true;
            }
        });

        eyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eyes.setBackgroundColor(Color.BLUE);
                Eyes = true;
            }
        });

        nose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nose.setBackgroundColor(Color.BLUE);
                Nose = true;
            }
        });

        mouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mouth.setBackgroundColor(Color.BLUE);
                Mouth = true;
            }
        });

        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();
                String value = "2";

                if (selectedItem == "Male"){
                    value = "2";
                } else if (selectedItem == "Female") {
                    value = "3";
                }

                OkHttpClient client = new OkHttpClient();

                RequestBody formBody = new FormBody.Builder()
                        .add("SessionID", sessionID)
                        .add("name", "Gender")
                        .add("value", value)
                        .build();

                Request request = new Request.Builder()
                        .url("https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature/UpdateFeature?name=Gender" + "&value="+value+"&SessionID="+sessionID)
                        .post(formBody)
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    Toast.makeText(feature.this, "Successful Gender", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // Perform actions based on the selected item

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        spinnerCough.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private boolean isFirstSelection = true;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (isFirstSelection) {
                    isFirstSelection = false;
                    return; // Skip the first selection
                }

                String selectedItem = parent.getItemAtPosition(i).toString();
                String value = "2";

                if (selectedItem == "No"){
                    value = "2";
                } else if (selectedItem == "Mild") {
                    value = "3";
                } else if (selectedItem == "Moderate") {
                    value = "4";
                } else if (selectedItem == "Severe") {
                    value = "5";
                }

                OkHttpClient client = new OkHttpClient();

                RequestBody formBody = new FormBody.Builder()
                        .add("SessionID", sessionID)
                        .add("name", "SeverityCough")
                        .add("value", value)
                        .build();

                Request request = new Request.Builder()
                        .url("https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name=SeverityCough" + "&value="+value+"&SessionID="+sessionID)
                        .post(formBody)
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    Toast.makeText(feature.this, "Successful Cough", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // Perform actions based on the selected item

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });




        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Gender

                //AGE

                OkHttpClient client = new OkHttpClient();

                String value = age.getText().toString();

                RequestBody formBody = new FormBody.Builder()
                        .add("SessionID", sessionID)
                        .add("name", "Age")
                        .add("value", value)
                        .build();

                Request request = new Request.Builder()
                        .url("https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name=Age" + "&value="+value+"&SessionID="+sessionID)
                        .post(formBody)
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    Toast.makeText(feature.this, "Successful Age", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                //Temp


                String valueTemp = temperature.getText().toString();

                RequestBody formBody1 = new FormBody.Builder()
                        .add("SessionID", sessionID)
                        .add("name", "Temp")
                        .add("value", valueTemp)
                        .build();

                Request request1 = new Request.Builder()
                        .url("https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name=Temp" + "&value="+valueTemp+"&SessionID="+sessionID)
                        .post(formBody1)
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request1).execute();
                    Toast.makeText(feature.this, "Successful Temperature", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//            test

//                Intent intent = new Intent(feature.this,test.class);
//                intent.putExtra("id", sessionID);
//                startActivity(intent);


            }

        });


        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Head) {
                    selected.add("0");
                }
                if (Abdomen) {
                    selected.add("1");
                }
                if (Throat) {
                    selected.add("2");
                }
                if (LB) {
                    selected.add("3");
                }
                if (Ear) {
                    selected.add("4");
                }
                if (Eyes) {
                    selected.add("5");
                }
                if (Mouth) {
                    selected.add("6");
                }
                if (Nose) {
                    selected.add("7");
                }
                if (Heart) {
                    selected.add("8");
                }
                if (Joint){
                    selected.add("9");
                }
                if (Chest){
                    selected.add("10");
                }

                Intent intent = new Intent(feature.this,syptoms.class);
                intent.putStringArrayListExtra("Parts", (ArrayList<String>) selected);
                intent.putExtra("id",sessionID);
                startActivity(intent);
                finish();

//
            }
        });


    }

}