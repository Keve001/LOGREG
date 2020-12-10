package com.example.logreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Regisztracio extends AppCompatActivity {

    EditText email_Reg,felNev,passW,tel_Nev;
    Button btreg,btback;
    ABseged adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regisztracio);

        init();
        inClickLisener();


    }

    private void inClickLisener() {

        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                adatRogzites();
            }
        });

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visza = new Intent(Regisztracio.this,MainActivity.class);
                startActivity(visza);;
                finish();

            }
        });

    }

    private void adatRogzites() {
        String email=email_Reg.getText().toString();
        String user =felNev.getText().toString();
        String jelszo=passW.getText().toString();
        String teljesnev=tel_Nev.getText().toString();

        if (user.isEmpty()){
            Toast.makeText(this,"Név meg adása kotelezo",Toast.LENGTH_LONG).show();
            return;
        }
        if (email.isEmpty()){
            Toast.makeText(this,"Email meg adása kotelezo",Toast.LENGTH_LONG).show();
            return;
        }

        if (jelszo.isEmpty()){
            Toast.makeText(this,"Jelszó meg adása kotelezo",Toast.LENGTH_LONG).show();
            return;
        }
        if (teljesnev.isEmpty()){
            Toast.makeText(this,"Teljes név meg adása kotelezo",Toast.LENGTH_LONG).show();
            return;
        }

            boolean sikeres = adatbazis.adatRogzités(email,user,jelszo,teljesnev);
        if (sikeres)
        {
            Toast.makeText(this,"Sikeres regisztracio",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Sikertelen regisztracio",Toast.LENGTH_LONG).show();
        }


    }

    private void init() {
        email_Reg= (EditText) findViewById(R.id.email_reg);
        felNev= (EditText)findViewById(R.id.felnev);
        passW= (EditText)findViewById(R.id.passw);
        tel_Nev= (EditText)findViewById(R.id.tel_nev);

        btreg= (Button) findViewById(R.id.reg);
        btback= (Button) findViewById(R.id.back);
        adatbazis = new ABseged(Regisztracio.this);

    }
}
