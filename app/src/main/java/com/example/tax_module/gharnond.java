package com.example.tax_module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
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

public class gharnond extends AppCompatActivity {
    ImageView gharnond1,gharnond2;
    Button down1,down2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gharnond);

        gharnond1=findViewById(R.id.gharnond1);
        gharnond2=findViewById(R.id.gharnond2);
        down1=findViewById(R.id.down1);
        down2=findViewById(R.id.down2);



        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bit1 = (BitmapDrawable) gharnond1.getDrawable();
                if (bit1 != null) {
                    Bitmap bitmap = bit1.getBitmap();

                    FileOutputStream ostream = null;
                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); // Use the public Pictures directory
                    File dir = new File(file.getAbsolutePath() + "/Egram");
                    dir.mkdirs(); // Make sure the directory exists

                    String filename = String.format("%S.png",gharnond1.getContentDescription() );

                    File outputfile = new File(dir, filename);

                    try {
                        ostream = new FileOutputStream(outputfile);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                        ostream.flush();
                        ostream.close();

                        // Update the gallery
                        MediaScannerConnection.scanFile(gharnond.this,
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
                    Toast.makeText(gharnond.this, "download successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(gharnond.this, "download failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BitmapDrawable bit = (BitmapDrawable) gharnond2.getDrawable();
                if (bit != null) {
                    Bitmap bitmap1 = bit.getBitmap();

                    FileOutputStream ostream = null;
                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); // Use the public Pictures directory
                    File dir = new File(file.getAbsolutePath() + "/Egram");
                    dir.mkdirs(); // Make sure the directory exists

                    String filename = String.format("%S.png",gharnond2.getContentDescription() );

                    File outputfile = new File(dir, filename);

                    try {
                        ostream = new FileOutputStream(outputfile);
                        bitmap1.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                        ostream.flush();
                        ostream.close();

                        // Update the gallery
                        MediaScannerConnection.scanFile(gharnond.this,
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
                    Toast.makeText(gharnond.this, "download successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(gharnond.this, "download failed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }


}