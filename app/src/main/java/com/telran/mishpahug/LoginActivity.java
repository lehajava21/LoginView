package com.telran.mishpahug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.telran.mishpahug.interactor.Interactor;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(btn != null){
            Intent intent = new Intent(this, EventViewDone.class);
            startActivity(intent);
        }
    }

    //--------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        Interactor.instance(this);
    }
    //--------------------------------------
}
