package com.example.kvana.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String DEFAULT="N/A";
    TextView usernameTextView,passwordTextView;

    public static void start(Context context) {
        Intent starter = new Intent(context, SecondActivity.class);
        context.startActivity(starter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        usernameTextView= (TextView) findViewById(R.id.textview1);
        passwordTextView= (TextView) findViewById(R.id.textview2);
    }

    public void load(View v){
        SharedPreferences sharedpreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
       String name= sharedpreferences.getString("name",DEFAULT);
        String password=sharedpreferences.getString("password",DEFAULT);
        if(name.equals(DEFAULT)|| password.equals(DEFAULT)){
            Toast.makeText(this,"No data was found",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"data was loaded", Toast.LENGTH_LONG).show();
            usernameTextView.setText(name);
            passwordTextView.setText(password);
        }
    }

    public void previous(View v){
        Toast.makeText(this,"previous",Toast.LENGTH_LONG).show();
        MainActivity.start(this);
    }
}
