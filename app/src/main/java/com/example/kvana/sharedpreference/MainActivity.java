package com.example.kvana.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button b;
    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.uname_et);
        password= (EditText) findViewById(R.id.pass_et);
    }

    public void save(View v){
        SharedPreferences sharedpreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedpreferences.edit();
        editor.putString("name",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();
        Toast.makeText(this,"Data was saved successfully",Toast.LENGTH_LONG).show();
    }

    public void next(View v){
        Toast.makeText(this,"Next",Toast.LENGTH_LONG).show();
      SecondActivity.start(this);

    }
}
