package com.example.med_assist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EndlessMedical extends AppCompatActivity {

    String sessionId;

    public EndlessMedical() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless_medical);
        TextView textView = findViewById(R.id.testText);
        Button accept = findViewById(R.id.accept);


        // get session id
        OkHttpClient client = new OkHttpClient();
        String url_sessionId = "https://endlessmedicalapi1.p.rapidapi.com/InitSession";
        Request request = new Request.Builder()
                .url(url_sessionId)
                .get()
                .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                Toast.makeText(EndlessMedical.this, "Error +", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String resp = response.body().string();
                    EndlessMedical.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject jsonObject = new JSONObject(resp);
                                String val1 = jsonObject.getString("status");
                                String val2 = jsonObject.getString("SessionID");
                                textView.setText("Your session ID is : " + val2);
                                sessionId = val2;
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    });
                }

            }
        });
//


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_ATOS = "https://endlessmedicalapi1.p.rapidapi.com/AcceptTermsOfUse?SessionID="+sessionId+"&passphrase="+"I have read, understood and I accept and agree to comply with the Terms of Use of EndlessMedicalAPI and Endless Medical services. The Terms of Use are available on endlessmedical.com";

                RequestBody formBody = new FormBody.Builder()
                        .add("SessionID", sessionId)
                        .add("passphrase", "I have read, understood and I accept and agree to comply with the Terms of Use of EndlessMedicalAPI and Endless Medical services. The Terms of Use are available on endlessmedical.com")
                        .build();

                Request request1 = new Request.Builder()
                        .url(url_ATOS)
                        .post(formBody)

                        .addHeader("X-RapidAPI-Key", "3e7f6cf93bmsh01ecf416f76f66bp1530e1jsn2c928a1a48d3")
                        .addHeader("X-RapidAPI-Host", "endlessmedicalapi1.p.rapidapi.com")
                        .build();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);

                try {
                    Response response = client.newCall(request1).execute();
                    Toast.makeText(EndlessMedical.this, "Accepted", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                accept.setVisibility(View.GONE);
                Intent intent = new Intent(EndlessMedical.this, feature.class);
                intent.putExtra("id", sessionId);
                startActivity(intent);

            }

        });

    //getFeatures


    }




}