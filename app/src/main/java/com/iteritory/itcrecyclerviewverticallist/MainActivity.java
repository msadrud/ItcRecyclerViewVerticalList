package com.iteritory.itcrecyclerviewverticallist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iteritory.itcrecyclerviewverticallist.adapter.RecyclerViewVerticalListAdapter;
import com.iteritory.itcrecyclerviewverticallist.model.Grocery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Grocery> groceryList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private RecyclerViewVerticalListAdapter groceryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryRecyclerView = findViewById(R.id.idRecyclerViewVerticalList);
        // add a divider after each item for more clarity
        groceryRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        groceryAdapter = new RecyclerViewVerticalListAdapter(groceryList, getApplicationContext());
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        groceryRecyclerView.setLayoutManager(verticalLayoutManager);
        groceryRecyclerView.setAdapter(groceryAdapter);
        populategroceryList();
    }

    private void populategroceryList(){
        Grocery potato = new Grocery("Potato", R.drawable.potato);
        Grocery onion = new Grocery("Onion", R.drawable.onion);
        Grocery cabbage = new Grocery("Cabbage", R.drawable.cabbage);
        Grocery cauliflower = new Grocery("Cauliflower", R.drawable.cauliflower);
        groceryList.add(potato);
        groceryList.add(onion);
        groceryList.add(cabbage);
        groceryList.add(cauliflower);
        groceryAdapter.notifyDataSetChanged();
    }
}
