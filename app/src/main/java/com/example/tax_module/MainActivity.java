package com.example.tax_module;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView gallery;
    ImageView contact;
    ImageView committie;
    ImageView village;
    ImageView tax;
    ImageView complaints;
    ImageView schemes;
ImageView application;
ImageView reqdoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        gallery=findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gal_next=new Intent(MainActivity.this, Gallery_activity.class);
                startActivity(gal_next);

            }
        });

        contact=findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cont_next=new Intent(MainActivity.this, ContactUs.class);
                startActivity(cont_next);

            }
        });


        committie=findViewById(R.id.committie);
        committie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comty_next=new Intent(MainActivity.this, Comittee.class);
                startActivity(comty_next);

            }
        });


        village=findViewById(R.id.village);
        village.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vlg_next=new Intent(MainActivity.this,Village_Activity.class);
                startActivity(vlg_next);
            }
        });


        tax=findViewById(R.id.tax1);
        tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tax_next=new Intent(MainActivity.this, Tax_Login.class);
                startActivity(tax_next);
            }
        });


        complaints=findViewById(R.id.complaints);
        complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comp_next= new Intent(MainActivity.this, Complaints.class);
                startActivity(comp_next);
            }
        });

        schemes=findViewById(R.id.schemes);
        schemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sch_next= new Intent(MainActivity.this, Schemess.class);
                startActivity(sch_next);
            }
        });

        application=findViewById(R.id.application);
        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent app_next= new Intent(MainActivity.this, Application2.class);
                startActivity(app_next);
            }
        });


        reqdoc=findViewById(R.id.reqdoc);
        reqdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doc_next= new Intent(MainActivity.this, reqdocument.class);
                startActivity(doc_next);
            }
        });

    }




}

