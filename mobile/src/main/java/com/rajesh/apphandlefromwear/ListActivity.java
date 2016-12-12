package com.rajesh.apphandlefromwear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener {

    private RecyclerView rvUsers;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter mAdapter;
    private ArrayList<String> listOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        findViews();
        initArray();

        mLayoutManager = new LinearLayoutManager(ListActivity.this);
        rvUsers.setLayoutManager(mLayoutManager);
        rvUsers.setHasFixedSize(true);


        mAdapter = new ListAdapter(ListActivity.this, listOfUsers);

        rvUsers.setAdapter(mAdapter);

        rvUsers.addOnItemTouchListener(new RecyclerItemClickListener(ListActivity.this,
                rvUsers, ListActivity.this));


    }

    private void findViews() {

        rvUsers = (RecyclerView) findViewById(R.id.recycler_mainlist);
    }

    private void initArray() {

        listOfUsers = new ArrayList<>();

        listOfUsers.add("Rajesh");
        listOfUsers.add("Paresh");
        listOfUsers.add("Ravi");
        listOfUsers.add("Rajendra");
        listOfUsers.add("Sagar");
        listOfUsers.add("Suyal");
        listOfUsers.add("Hardik");
        listOfUsers.add("Nikunj");
        listOfUsers.add("Keyur");
        listOfUsers.add("Tejas");


    }

    @Override
    public void onItemClick(View view, int position) {

        String key = (String) mAdapter.getItem(position);

        Intent i = new Intent(this,DetailActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("username",key);
        startActivity(i);


    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
