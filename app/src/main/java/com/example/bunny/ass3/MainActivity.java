package com.example.bunny.ass3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                isConnected();
                DSync dsync= (DSync) new DSync().execute("");
            }

        });
    }
    public  void isConnected()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager!=null)
            Toast.makeText(getApplicationContext(), " Network Available", Toast.LENGTH_SHORT).show();
        {
            NetworkInfo info=connectivityManager.getActiveNetworkInfo();
            if (info!=null && info.getState()==NetworkInfo.State.CONNECTED)
            {

                Toast.makeText(getApplicationContext(), " Network Connected", Toast.LENGTH_SHORT).show();
                //  return true;

            }else{
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
        //  return false;
    }
}
