package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nev_Email, Jelszo;
    Button btlogin, btregiszt;
    ABseged adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ini();
        onClickLisener();
    }
    public boolean ellen()
    {

        String user = nev_Email.getText().toString();
        String jelszo = Jelszo.getText().toString();
        String email = nev_Email.getText().toString();
        boolean enged = true;

        if (!adatbazis.check(user,jelszo,email)) {
            enged = false;
            Toast.makeText(this, "Nincs ilyen Felhasználó", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "van ilyen felhasználó", Toast.LENGTH_SHORT).show();
        }
        return enged;

    }

    private void onClickLisener() {
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ellen())
                {
                    Intent bejelentkezes = new Intent(getApplicationContext(), Login.class);
                    startActivity(bejelentkezes);
                    finish();
                }
            }
        });
        btregiszt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), Regisztracio.class);
                startActivity(register);
                finish();
            }
        });

    }


    private void ini() {

        btlogin = findViewById(R.id.login);
        btregiszt = findViewById(R.id.regiszt);
        nev_Email = findViewById(R.id.nev_email);
        Jelszo = findViewById(R.id.jelszo);
        adatbazis = new ABseged(MainActivity.this);

    }
}