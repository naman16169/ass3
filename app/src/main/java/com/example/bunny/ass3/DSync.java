package com.example.bunny.ass3;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DSync extends AsyncTask<String, Void, String> {
    public FileInputStream fileInputStream;
    public HttpURLConnection conn;

    @Override
    protected String doInBackground(String... params) {

        try {

                    fileInputStream = new FileInputStream(new File("/data/data/com.example.bunny.ass3/files/data.csv"));

                    conn = (HttpURLConnection) new URL("http://192.168.0.101").openConnection();
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestProperty("Content-Type",
                            "multipart/form-data;boundary=" + "*****");
                    conn.setRequestProperty("bill", "/data/data/com.example.bunny.ass3/files/data.csv");

                    DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

                    dos=doing(dos);


                    int bufferSize;
                    if(fileInputStream.available()<1024 * 1024){
                        bufferSize=fileInputStream.available();
                    }
                    else{
                        bufferSize=1024 * 1024;
                    }
                    byte[] buffer= new byte[bufferSize];

                    int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                    while (bytesRead > 0) {

                        dos.write(buffer, 0, bufferSize);
                        if(fileInputStream.available()<1024 * 1024){
                            bufferSize=fileInputStream.available();
                        }
                        else{
                            bufferSize=1024 * 1024;
                        }
                        bytesRead = fileInputStream.read(buffer, 0,
                                bufferSize);

                    }
                    dos=doing2(dos);

                    conn.getResponseCode();
        }
        catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }

    public DataOutputStream doing(DataOutputStream dos) throws IOException {
        dos.writeBytes("--" + "*****" + "\r\n");
        dos.writeBytes("Content-Disposition: form-data; name=\"bill\";filename=\""
                + "/data/data/com.example.bunny.ass3/files/data.csv" + "\"" + "\r\n");

        dos.writeBytes("\r\n");

        return dos;
    }

    public DataOutputStream doing2(DataOutputStream dos) throws IOException {
        dos.writeBytes("\r\n");
        dos.writeBytes("--" + "*****" + "--"
                + "\r\n");
        return dos;
    }
}