package esgi.java.advanced.ui.desktop.app;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonRead {

    public static JSONArray call_me(String url ) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
       // System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //System.out.println(response.toString());

        JSONArray arr = new JSONArray(response.toString());
      //  System.out.println(arr);
       // for (int i = 0; i < arr.length(); i++) {
       //     JSONObject  o = arr.getJSONObject(i);
      //     System.out.println(o.get("email"));
      //  }

        return arr;
    }



}
