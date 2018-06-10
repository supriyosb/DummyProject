package HttpCalls;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;
import java.util.Map;

public class HttpCalls {

    HttpClient httpClient;
    HttpPost httpPost;
    HttpResponse response;

    public HttpCalls() {
        httpClient = new DefaultHttpClient();
    }

    public void doGet(){

    }

    public HttpResponse doPost(String uri, Map<String, String> headerMap, String payLoad){
        httpPost = new HttpPost(uri);
        try{
            for(Map.Entry entry : headerMap.entrySet()){
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                httpPost.setHeader(key, value);
            }
            httpPost.setEntity(new StringEntity(payLoad));
            response = httpClient.execute(httpPost);
        } catch (Exception e){

        }
        return response;
    }

    public void doUpdate(){

    }

    public void doDelete(){

    }
}
