package com.example.med_assist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Hospital extends AppCompatActivity {

    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        textView = findViewById(R.id.hospital_names);

        OkHttpClient client = new OkHttpClient();
        String url_sessionId = "https://api.data.gov.in/resource/de59e770-2333-4eaf-9088-a3643de040c8?api-key=579b464db66ec23bdd000001e8f49f27bd5f40516162926a64b9c2a7&format=json";
        Request request = new Request.Builder()
                .url(url_sessionId)
                .get()
                .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                Toast.makeText(Hospital.this, "Error +", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    Hospital.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject dataObject = new JSONObject(responseBody);
                                JSONArray recordsArray = dataObject.getJSONArray("records");

                                // Iterate over each hospital record
                                for (int i = 0; i < recordsArray.length(); i++) {
                                    JSONObject record = recordsArray.getJSONObject(i);

                                    String city = record.getString("cityname");
                                    String hospitalName = record.getString("hospitalname");
                                    String hospitalAddress = record.getString("hospitaladdress");

                                    textView.append(city + "\n" + hospitalName + "\n" + hospitalAddress+"\n\n");
                                }
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
//
                    });
                }
                else{
                    textView.setText("Unsuccessful");
                }

            }
        });

    }
}