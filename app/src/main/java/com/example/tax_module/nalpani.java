package com.example.tax_module;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class nalpani extends AppCompatActivity {
    ImageView nalimg;
    Button downnal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nalpani);

        nalimg=findViewById(R.id.nalimg);
        downnal=findViewById(R.id.downnal);

        downnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bit1 = (BitmapDrawable) nalimg.getDrawable();
                if (bit1 != null) {
                    Bitmap bitmap = bit1.getBitmap();

                    FileOutputStream ostream = null;
                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); // Use the public Pictures directory
                    File dir = new File(file.getAbsolutePath() + "/Egram");
                    dir.mkdirs(); // Make sure the directory exists

                    String filename = String.format("%S.png",nalimg.getContentDescription() );

                    File outputfile = new File(dir, filename);

                    try {
                        ostream = new FileOutputStream(outputfile);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                        ostream.flush();
                        ostream.close();

                        // Update the gallery
                        MediaScannerConnection.scanFile(nalpani.this,
                                new String[]{outputfile.toString()},
                                null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        // Gallery update is complete
                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(nalpani.this, "download successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(nalpani .this, "download failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}