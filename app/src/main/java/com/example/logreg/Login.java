package com.example.logreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    TextView vmi;
    Button kijelent;
    ABseged adatbazis;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bejelentkezettact);

        ini();
        onClickLisener();

    }

    private void onClickLisener() {
        kijelent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kijelentkezes = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(kijelentkezes);
                finish();
            }
        });


    }
    private void ini() {

        vmi = findViewById(R.id.bej);
        kijelent = findViewById(R.id.logout);
        adatbazis = new ABseged(Login.this);

    }
}





