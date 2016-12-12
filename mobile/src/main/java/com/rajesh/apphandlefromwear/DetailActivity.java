package com.rajesh.apphandlefromwear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String userName  = getIntent().getStringExtra("username");

        TextView tvUser = (TextView) findViewById(R.id.tv_username);
        tvUser.setText(userName);

    }
}
