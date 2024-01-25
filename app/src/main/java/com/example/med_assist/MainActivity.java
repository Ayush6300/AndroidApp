package com.example.med_assist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;


    int[] covers = new int[]{
            R.drawable.hospital,
            R.drawable.medicine,
            R.drawable.diagnosis,
            R.drawable.vaccine
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_menu_24);


        recyclerView = findViewById(R.id.recycler_main);
        appList = new ArrayList<>();

        adapter = new RecyclerViewAdapter(this, appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        InitializeDataIntoRecyclerView();
    }

    private void InitializeDataIntoRecyclerView() {

        row a = new row(covers[0]);
        appList.add(a);

        a = new row(covers[1]);
        appList.add(a);

        a= new row(covers[2]);
        appList.add(a);

        a = new row(covers[3]);
        appList.add(a);

        adapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}