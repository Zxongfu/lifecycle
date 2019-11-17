package com.example.lifecycle;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private Button button;
    private String tag="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);
        button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtra("result","123456");
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

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"--onPause--");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"--onStop--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag,"--onRestart--");

    }

}
