package com.example.med_assist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Med_window extends AppCompatActivity implements Listener{

    TextView textView_name, type, quantity, sideEffects, Uses, stock, drugs;
    private List<Medicine_image> dataList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_window);

        textView_name = findViewById(R.id.med_window_id);
        type = findViewById(R.id.med_type);
        quantity = findViewById(R.id.med_quantity);
        sideEffects = findViewById(R.id.med_sideEffects);
        Uses = findViewById(R.id.uses);
        stock = findViewById(R.id.stock);
        drugs = findViewById(R.id.drugs);

        RecyclerView recyclerView = findViewById(R.id.med_window_recycler);

        Intent intent = getIntent();
        String product_Id = intent.getStringExtra("product_Id");
        textView_name.setText(product_Id);

        OkHttpClient client = new OkHttpClient();
        String url_sessionId = "https://beta.myupchar.com/api/medicine/detail?api_key=dce7b746036070aa1d122ad39e2c8904&product_id="+product_Id;
        Request request = new Request.Builder()
                .url(url_sessionId)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                Toast.makeText(Med_window.this, "Error +", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    Med_window.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject jsonObject = new JSONObject(responseBody);
//                                JSONArray jsonArray =jsonObject.getJSONArray("details");
                                String name =jsonObject.getJSONObject("details").getString("name");
                                String otc_type =jsonObject.getJSONObject("details").getString("otc_type");
                                String qty =jsonObject.getJSONObject("details").getString("form");

                                JSONObject details = jsonObject.getJSONObject("details");
                                JSONArray sideEffectsArray = details.getJSONArray("side_effects");

                                for (int i = 0; i < sideEffectsArray.length(); i++) {
                                    String effects = sideEffectsArray.getString(i);
                                    sideEffects.append(effects+"\n");
                                    // Use the side effect value as needed
                                }
                                JSONObject uses = details.getJSONObject("uses");

                                // Retrieve the "main" uses array
                                JSONArray mainUsesArray = uses.getJSONArray("main");
                                for (int i = 0; i < mainUsesArray.length(); i++) {
                                    String mainUse = mainUsesArray.getString(i);
                                    // Use the main use value as needed
                                    Uses.append(mainUse + "\n");
                                }

                                // Retrieve the "others" uses array
                                JSONArray othersUsesArray = uses.getJSONArray("others");
                                for (int i = 0; i < othersUsesArray.length(); i++) {
                                    String otherUse = othersUsesArray.getString(i);
                                    // Use the other use value as needed
                                    Uses.append(otherUse + "\n");
                                }
                                String InStock =jsonObject.getJSONObject("details").getString("in_stock");

                                //images

                                JSONArray imageArray = details.getJSONArray("image_array");
                                for (int i = 0; i < imageArray.length(); i++) {
                                    String img = imageArray.getString(i);
                                    dataList.add(new Medicine_image(img));


                                    MedImageRecycleAdapter adapter = new MedImageRecycleAdapter(dataList, Med_window.this);
                                    recyclerView.setAdapter(adapter);
                                    recyclerView.setLayoutManager(new LinearLayoutManager(Med_window.this));
                                    // Use the side effect value as needed
                                }
//
//                                JSONArray drugNamesArray = details.getJSONArray("drug_names");
//
//                                for (int i = 0; i < drugNamesArray.length(); i++) {
//                                    String drug = drugNamesArray.getString(i);
//                                    drugs.append(drug+"\n");
//                                }

                                stock.append(InStock);
                                textView_name.setText(name);
                                type.setText(otc_type);
                                quantity.setText(qty);



//                                String val2 = jsonObject.getString("SessionID");
//                                sessionId = val2;
//                                    String Image = record.getString("image");
//                                    String description = record.getString("form");
//                                    String MRP = record1.getString("mrp");
//                                    String FinalPrice = record1.getString("final_price");
//                                    String Discount = record1.getString("discount_perc");
//                                    String id = record.getString("product_id");
//                                    textView.setText(name);


//                                            textView.append(product_id+"\n");
//                                            Glide.with(Medicines.this).load(Image).into(img);
//                                    dataList.add(new medItems(Image, product_id, description,MRP,FinalPrice,Discount,id));
//                                            dataList.add(new medItems(R.drawable.image2, "Item 2", "Description 2"));
//                                            dataList.add(new medItems(R.drawable.image3, "Item 3", "Description 3"));


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
//
                    });
                }
                else{
                    Toast.makeText(Med_window.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onItemClicked(int position) {

    }
}