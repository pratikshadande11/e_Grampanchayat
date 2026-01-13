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

public class gharmoj extends AppCompatActivity {
    ImageView gharmojni;
    Button downgharmoj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gharmoj);

        gharmojni=findViewById(R.id.gharmojni);
        downgharmoj=findViewById(R.id.downgharmoj);

        downgharmoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bit1 = (BitmapDrawable) gharmojni.getDrawable();
                if (bit1 != null) {
                    Bitmap bitmap = bit1.getBitmap();

                    FileOutputStream ostream = null;
                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); // Use the public Pictures directory
                    File dir = new File(file.getAbsolutePath() + "/Egram");
                    dir.mkdirs(); // Make sure the directory exists

                    String filename = String.format("%S.png",gharmojni.getContentDescription() );

                    File outputfile = new File(dir, filename);

                    try {
                        ostream = new FileOutputStream(outputfile);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                        ostream.flush();
                        ostream.close();

                        // Update the gallery
                        MediaScannerConnection.scanFile(gharmoj.this,
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
                    Toast.makeText(gharmoj.this, "download successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(gharmoj .this, "download failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}