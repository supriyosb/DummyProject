package utils;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    public static String getStringContent(HttpResponse response){
        String strResult = null;
        try{
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            strResult = String.valueOf(result);
        } catch (Exception e){

        }
        return strResult;
    }
}
