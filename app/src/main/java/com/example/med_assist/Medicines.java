package com.example.med_assist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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

public class Medicines extends AppCompatActivity implements Listener{

    EditText editText;
    ImageView img;
    ImageButton btn;
    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;
   private List<medItems> dataList = new ArrayList<>();

    private List<String> imageUrlList;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);
        btn = findViewById(R.id.imgbtn);
        editText = findViewById(R.id.med_search);
        img = findViewById(R.id.Medicine_Image);
//
//        manager = new StaggeredGridLayoutManager(2,
//                StaggeredGridLayoutManager.VERTICAL);
//
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);


        RecyclerView recyclerView = findViewById(R.id.med_recycler);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String MedName = editText.getText().toString();

                OkHttpClient client = new OkHttpClient();
                String url_sessionId = "https://beta.myupchar.com/api/medicine/search?api_key=dce7b746036070aa1d122ad39e2c8904&name="+MedName;
                Request request = new Request.Builder()
                        .url(url_sessionId)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                        Toast.makeText(Medicines.this, "Error +", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()){
                            String responseBody = response.body().string();
                            Medicines.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        JSONObject dataObject = new JSONObject(responseBody);
                                        JSONArray recordsArray = dataObject.getJSONArray("data");
                                        // Iterate over each hospital record
                                        for (int i = 0; i < recordsArray.length(); i++) {
                                            JSONObject record = recordsArray.getJSONObject(i);
                                            JSONObject record1 = recordsArray.getJSONObject(i).getJSONObject("price");

                                            String product_id = record.getString("name");
                                            String Image = record.getString("image");
                                    String description = record.getString("form");
                                    String MRP = record1.getString("mrp");
                                    String FinalPrice = record1.getString("final_price");
                                    String Discount = record1.getString("discount_perc");
                                    String id = record.getString("product_id");


//                                            textView.append(product_id+"\n");
//                                            Glide.with(Medicines.this).load(Image).into(img);
                                            dataList.add(new medItems(Image, product_id, description,MRP,FinalPrice,Discount,id));
//                                            dataList.add(new medItems(R.drawable.image2, "Item 2", "Description 2"));
//                                            dataList.add(new medItems(R.drawable.image3, "Item 3", "Description 3"));

                                        }
                                        med_recycler_adapter adapter = new med_recycler_adapter(dataList, Medicines.this);
                                        recyclerView.setAdapter(adapter);
                                        recyclerView.setLayoutManager(new LinearLayoutManager(Medicines.this));


                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
//
                            });
                        }
                        else{
                            Toast.makeText(Medicines.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

        });
    }

    @Override
    public void onItemClicked(int position) {

        medItems item = med_recycler_adapter.getItem(position);
        String P_id = item.getId();

        Intent intent = new Intent(Medicines.this, Med_window.class);
        intent.putExtra("product_Id", P_id);
        startActivity(intent);


    }
}