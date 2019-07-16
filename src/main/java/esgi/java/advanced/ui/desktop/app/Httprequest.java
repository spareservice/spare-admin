package esgi.java.advanced.ui.desktop.app;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.util.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Httprequest {

    public static int  deleteRequete(URL url) {
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = null;
        int  code = 0;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("DELETE");
            code= httpURLConnection.getResponseCode();
            //System.out.println(code);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return code;
    }



    public static int get(URL url) {
         HttpURLConnection httpURLConnection = null;
         httpURLConnection = null;
        int  code = 0;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            code= httpURLConnection.getResponseCode();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return code;
    }
public static int postRequest(URL url, String data[]  ) throws IOException {
    HttpURLConnection httpURLConnection = null;
    int  code = 0;

    try {
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");

        List <NameValuePair> params = new ArrayList <NameValuePair>();
for(int i=0;i<params.size();i++){

    params.add(new BasicNameValuePair("@id"+i,data[i]));
}

        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        code= httpURLConnection.getResponseCode();
       //
        // System.out.println(params);
        writer.flush();
        writer.close();
        os.close();
        httpURLConnection.connect();
      //  System.out.println(code);
    } catch (IOException exception) {
        exception.printStackTrace();
    }

return code;

}





}
