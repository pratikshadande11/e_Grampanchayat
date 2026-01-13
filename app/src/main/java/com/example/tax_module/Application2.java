package com.example.tax_module;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Application2 extends AppCompatActivity {
    Button gharnond,gharmoj,nalpani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        gharnond=findViewById(R.id.gharnond);
        gharmoj=findViewById(R.id.gharmojni2);
        nalpani=findViewById(R.id.nalpani);

        ActivityCompat.requestPermissions(Application2.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(Application2.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        gharnond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gharnond_next=new Intent(Application2.this, com.example.tax_module.gharnond.class);
                startActivity(gharnond_next);
            }
        });

        gharmoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gharmoj_next=new Intent(Application2.this, com.example.tax_module.gharmoj.class);
                startActivity(gharmoj_next);
            }
        });

        nalpani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gharmoj_next=new Intent(Application2.this, com.example.tax_module.gharmoj.class);
                startActivity(gharmoj_next);
            }
        });
    }
}