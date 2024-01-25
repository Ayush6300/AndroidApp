package com.example.med_assist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class test extends AppCompatActivity {
    EditText analyze;
    TextView txt, suggested_feature;
    Button button;
    String id, temp;

    private static final String BASE_URL = "http://api.endlessmedical.com/v1/dx";
    private Handler mainHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        analyze = findViewById(R.id.analyze);
        button = findViewById(R.id.id_verifier);
        txt = findViewById(R.id.textViw3);
        suggested_feature = findViewById(R.id.suggestedFeature);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        analyze.setText(id);
        // Initialize the main handler to update UI elements on the main thread
        mainHandler = new Handler(Looper.getMainLooper());

        String strSessionID = id;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("https://endlessmedicalapi1.p.rapidapi.com/Analyze?SessionID="+ strSessionID)
                        .get()
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client.newCall(request).execute();

                    if (response.isSuccessful()){
//                        txt.setText("Successful");

                        String resp = response.body().string();
                        test.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(resp);
                                    String val1 = jsonObject.getString("status");
                                    JSONArray jarrDiseases = jsonObject.getJSONArray("Diseases");

                                    for (int i = 0; i < jarrDiseases.length(); i++) {
                                    JSONObject diseaseItem = jarrDiseases.getJSONObject(i);
                                    String diseaseName = diseaseItem.keys().next();
                                    String diseaseProbability = diseaseItem.getString(diseaseName);

                                    // Post a Runnable on the main thread to update the UI
                                    mainHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
//                                            TextView textView = findViewById(R.id.textViw3);
                                            txt.append("Disease " + diseaseName + " with probability " + diseaseProbability+"\n"+"\n");
                                        }
                                    });
                                }

//                                    txt.setText("Status : " + val1);
//                                    sessionId = val2;
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        });

                    }
                    else{
                        txt.setText("Unsuccessful");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


//                client.newCall(request).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        e.printStackTrace();
//                        temp = "Failed call";
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        if (response.isSuccessful()) {
//                            String responseBody = response.body().string();
//
//                            try {
//                                JSONObject jAnalyzeObject = new JSONObject(responseBody);
//                                JSONArray jarrDiseases = jAnalyzeObject.getJSONArray("Diseases");
//
//                                for (int i = 0; i < jarrDiseases.length(); i++) {
//                                    JSONObject diseaseItem = jarrDiseases.getJSONObject(i);
//                                    final String diseaseName = diseaseItem.keys().next();
//                                    final String diseaseProbability = diseaseItem.getString(diseaseName);
//
//                                    // Post a Runnable on the main thread to update the UI
//                                    mainHandler.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            TextView textView = findViewById(R.id.textViw3);
//                                            textView.setText("Disease " + diseaseName + " with probability " + diseaseProbability);
//                                        }
//                                    });
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                                temp = "catch error";
//                            }
//                        } else {
//                            // Handle the response failure
//                            // For example, you can get the response code and error message
//                            int responseCode = response.code();
//                            String errorMessage = response.message();
//                            temp = "errorMessage";
//                        }
//
//                        // Remember to close the response body
//                        Toast.makeText(test.this, temp, Toast.LENGTH_SHORT).show();
//                        response.close();
//                    }
//                });

                button.setVisibility(View.GONE);

                //GET SUGGESTED FEATURE
                OkHttpClient client_suggest = new OkHttpClient();

                Request request_suggest = new Request.Builder()
                        .url("https://api.endlessmedical.com/v1/dx/GetSuggestedFeatures_PatientProvided?SessionID="+ strSessionID+"&TopDiseasesToTake=10")
                        .get()
                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();

                try {
                    Response response = client_suggest.newCall(request_suggest).execute();

                    if (response.isSuccessful()){

                        String resp = response.body().string();
                        test.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(resp);
                                    String jsonArrayString = jsonObject.getString("SuggestedFeatures");

                                    JSONArray jsonArray = new JSONArray(jsonArrayString);

                                    // Accessing elements of the JSON array
                                    String element1 = jsonArray.getString(0);
                                    String element2 = jsonArray.getString(1);
                                    String element3 = jsonArray.getString(2);
                                    String element4 = jsonArray.getString(3);
                                    String element5 = jsonArray.getString(4);
//                                    JSONArray jarrDiseases = jsonObject.getJSONArray("SuggestedFeatures");

//                                    for (int i = 0; i < jarrDiseases.length(); i++) {
//                                        JSONObject diseaseItem = jarrDiseases.getJSONObject(i);
//                                        String diseaseName = diseaseItem.keys().next();
//                                        String diseaseProbability = diseaseItem.getString(diseaseName);
//
//                                        // Post a Runnable on the main thread to update the UI
//                                        mainHandler.post(new Runnable() {
//                                            @Override
//                                            public void run() {
////                                            TextView textView = findViewById(R.id.textViw3);
                                                suggested_feature.append("Disease " + element1 +"\n"+"\n");
                                                suggested_feature.append("Disease " + element2 +"\n"+"\n");
                                                suggested_feature.append("Disease " + element3 +"\n"+"\n");
                                                suggested_feature.append("Disease " + element4 +"\n"+"\n");
                                                suggested_feature.append("Disease " + element5 +"\n"+"\n");
//                                            }
//                                        });
//                                    }
//
////                                    txt.setText("Status : " + val1);
////                                    sessionId = val2;
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        });

                    }
                    else{
                        txt.setText("Unsuccessful");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });


    }


}