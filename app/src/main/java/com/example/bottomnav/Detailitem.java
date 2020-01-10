package com.example.bottomnav;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detailitem extends AppCompatActivity {

    private TextView txt;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailitem);
        txt=findViewById(R.id.text);
        if(getIntent().hasExtra("key")){
            name=getIntent().getStringExtra("key");
        }
        txt.setText(name);
    }
}
