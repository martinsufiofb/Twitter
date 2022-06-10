package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CommentActivity extends AppCompatActivity {
    TextView textView2;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        textView2 = findViewById(R.id.textView2);
        Bundle extra = getIntent().getExtras();
        value=getIntent().getStringExtra("key");
        textView2.setText(value);
//        if (extra!=null){
//            //value =extra.getString("key");
//            //textView2.setText(value);
//        }



    }
}