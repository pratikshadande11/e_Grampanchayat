package com.example.tax_module;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
public class Tax_Login extends AppCompatActivity {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_AMOUNT= "amount";
    public static final String EXTRA_PLOT= "plot";
    public static final String EXTRA_AREA= "area";
    String area2,plot2;
    EditText etxt_plot;
    Button btn_next;
    DataBaseHelper mydb;
    String[] area1={"Khivansara Nagar", "Dashmesha Nagar", "Sahyog Nagar", "Jagadamba Nagar", "Sahyadri Nagar","Waluj","Usamanpura"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_login);

        mydb= new DataBaseHelper(this);
        mydb.insertData("Pratiksha Dande","Khivansara Nagar", "33", "1000", "9503354853", "");
        mydb.insertData("Tanmay Shinde","Khivansara Nagar", "88", "2000", "7218364134", "");
        mydb.insertData("Gayatri Jadhav","Dashmesha Nagar", "28", "3000", "0011998855", "");
        mydb.insertData("Poonam Pathade","Waluj", "34", "4000", "9564432953", "");



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,area1);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.etxt_area);
        textView.setThreshold(1);
        textView.setAdapter(adapter);

        etxt_plot=findViewById(R.id.etxt_plot);
        btn_next=findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String plot=etxt_plot.getText().toString();
                String area=textView.getText().toString();
                Cursor res= mydb.readData(plot,area);
                if(res != null && res.moveToFirst()){
                    String name= res.getString(res.getColumnIndexOrThrow(mydb.COL_1));
                    String amount= res.getString(res.getColumnIndexOrThrow(mydb.COL_4));



                    Intent i= new Intent(Tax_Login.this, next_Pay.class);
                    i.putExtra(EXTRA_NAME, name);
                    i.putExtra(EXTRA_AMOUNT, amount);
//                    i.putExtra(EXTRA_PLOT, plot2);
//                    i.putExtra(EXTRA_AREA, area2);
                    startActivity(i);

                    res.close();

                }
            }

        });


    }
}