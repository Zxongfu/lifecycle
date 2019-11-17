package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String tag ="life";
    private Button button;
    private EditText editText;
    private String string;

    void testBranch() {
        Log.d("test","測試分支功能");
    }
    //use singleTask activity and use this method onNewIntent
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String string = intent.getStringExtra("result");
        Log.d(tag,string+"--onNewIntent--");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"--onCreate--");


        editText = findViewById(R.id.editText);

        //if have restore data get the data
        //test
        if (savedInstanceState!=null){
            editText.setText(string);
        }

        button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"--onResume--");

    }

    //when press home button get text
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"--onPause--");
        string = editText.getText().toString();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"--onStop--");
    }

    //when press home button restore text
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag,"--onRestart--");
        editText.setText(string);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag,"--onDestroy--");
    }


    //if rotate save data
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("string",string);

        super.onSaveInstanceState(outState);

    }


}
