package com.example.tax_module;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Complaints extends AppCompatActivity {

    Button btn_comp;
    EditText etxt_comp;

    DataBaseHelper2 mydb2;
    String[] area={"Khivansara Nagar", "Dashmesha Nagar", "Sahyog Nagar", "Jagadamba Nagar", "Sahyadri Nagar","Waluj","खिवांसरा नगर","दशमेशनगर","वाळूज","जगदंबा नगर","सह्योग नगर","सह्याद्री नगर"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);
        etxt_comp= findViewById(R.id.etxt_comp);
        btn_comp= findViewById(R.id.btn_comp);
        mydb2= new DataBaseHelper2(this);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,area);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.etxt_comp_area);
        textView.setThreshold(1);
        textView.setAdapter(adapter);

        btn_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comp= etxt_comp.getText().toString();
                String comp_area= textView.getText().toString();

                if(!comp.isEmpty() && !comp_area.isEmpty()){
                    if(mydb2.insertData2(comp_area,comp)){
                        Toast.makeText(Complaints.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Complaints.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });





    }
}



//package com.example.tax_module;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//public class Complaints extends AppCompatActivity {
//
//    Button btn_comp;
//    EditText etxt_comp_area, etxt_comp;
//    DataBaseHelper2 mydb2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_complaints);
//        etxt_comp= findViewById(R.id.etxt_comp);
//        etxt_comp_area= findViewById(R.id.etxt_comp_area);
//        btn_comp= findViewById(R.id.btn_comp);
//        mydb2= new DataBaseHelper2(this);
//
//
//        btn_comp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String comp= etxt_comp.getText().toString();
//                String comp_area= etxt_comp_area.getText().toString();
//
//                if(!comp.isEmpty() && !comp_area.isEmpty()){
//                    if(mydb2.insertData2(comp_area,comp)){
//                        Toast.makeText(Complaints.this, "Data inserted", Toast.LENGTH_SHORT).show();
//                    }else {
//                        Toast.makeText(Complaints.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });
//
//
//
//
//
//    }
//
//}

