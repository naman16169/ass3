package com.example.bunny.ass3;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    DatabaseHelp mDatabaseHelper= new DatabaseHelp(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Submit=(Button) findViewById(R.id.button3);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out=openFileOutput("data.csv", Context.MODE_PRIVATE);
                    mDatabaseHelper.exportCSV(out);
                    out.close();
                } catch (IOException e) {
                }
                DSync dsync= (DSync) new DSync().execute("");
            }

        });
    }
}
