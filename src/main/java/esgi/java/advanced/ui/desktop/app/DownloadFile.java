package esgi.java.advanced.ui.desktop.app;


import org.asynchttpclient.*;

import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFile  {
    // nous devons créer un client HTTP:
    private static AsyncHttpClient client = Dsl.asyncHttpClient();;


    public static void  download(String url ) throws Exception {
        /*
        URL obj = new URL(url);
        HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
        httpConnection.setRequestMethod("HEAD");
        long removeFileSize = httpConnection.getContentLengthLong();

     */
        //Le contenu téléchargé sera placé dans un FileOutputStream :
        FileOutputStream stream = new FileOutputStream("/Users/oualikenourdia/Desktop/ourdia.pdf");
        client.prepareGet(url).execute(new AsyncCompletionHandler <FileOutputStream>() {


            public State onBodyPartReceived(HttpResponseBodyPart bodyPart) throws Exception {

                stream.getChannel().write(bodyPart.getBodyByteBuffer());
                return AsyncHandler.State.CONTINUE;

            }


            public FileOutputStream onCompleted(Response response)
                    throws Exception {
                return stream;
            }
        });



    }
}
