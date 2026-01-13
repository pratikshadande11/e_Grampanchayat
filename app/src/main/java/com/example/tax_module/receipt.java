package com.example.tax_module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class receipt extends AppCompatActivity {
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_AMOUNT= "amount";
    public static final String EXTRA_PLOT= "plot";
    public static final String EXTRA_AREA= "area";
    String new_name, new_amount, new_plot, new_area;
    TextView re_name, re_total,re_plot, re_area, re_date;
    Button receipt_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        re_date= findViewById(R.id.re_date);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        // Set current date to TextView
        re_date.setText(currentDate);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("'Date\n'dd-MM-yyyy '\n\nand\n\nTime\n'HH:mm:ss z");
//
//        // on below line we are creating a variable
//        // for current date and time and calling a simple date format in it.
//        String currentDateAndTime = sdf.format(new Date());
//
//        // on below line we are setting current
//        // date and time to our text view.
//        re_date.setText(currentDateAndTime);



        Intent i_recipt= getIntent();
        new_name= i_recipt.getStringExtra(Tax_Login.EXTRA_NAME);
        new_amount= i_recipt.getStringExtra(Tax_Login.EXTRA_AMOUNT);
//        new_plot= i_recipt.getStringExtra(Tax_Login.EXTRA_PLOT);
//        new_area= i_recipt.getStringExtra(Tax_Login.EXTRA_AREA);

        re_total= findViewById(R.id.re_total);
        re_name= findViewById(R.id.re_name);
//        re_plot= findViewById(R.id.re_plot);
//        re_area= findViewById(R.id.re_area);

        re_name.setText(new_name);
        re_total.setText(new_amount);
//        re_plot.setText(new_plot);
//        re_area.setText(new_area);


        receipt_download= findViewById(R.id.receipt_download);
        receipt_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                covertXMLtoPDF();
                Toast.makeText(receipt.this, "Clicked", Toast.LENGTH_SHORT).show();
                covertXMLtoPDF();
            }
        });

        }

    private void covertXMLtoPDF() {
        View view= LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        DisplayMetrics displayMetrics= new DisplayMetrics();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            this.getDisplay().getRealMetrics(displayMetrics);
        }
        else this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.EXACTLY));

        PdfDocument document= new PdfDocument();

        int viewWidth= view.getMeasuredWidth();
        int viewHeight= view.getMeasuredHeight();

        view.layout(0,0,displayMetrics.widthPixels,displayMetrics.heightPixels);

        PdfDocument.PageInfo pageInfo= new PdfDocument.PageInfo.Builder(1080,1920,1).create();
        PdfDocument.Page page= document.startPage(pageInfo);

        Canvas canvas= page.getCanvas();
        view.draw(canvas);

        document.finishPage(page);

        //Download
        File downloadsDir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        String fileName= "exampleXML.pdf";
        File file = new File(downloadsDir, fileName);
        try {
            FileOutputStream fos= new FileOutputStream(file);
            document.writeTo(fos);
            document.close();
            fos.close();
            Toast.makeText(this, "Converted XML to PDF Successfully!!!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.d("mylog", "Error while writting" + e.toString());
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }


    }
