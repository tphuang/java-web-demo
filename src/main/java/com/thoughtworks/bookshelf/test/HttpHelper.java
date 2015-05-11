package com.thoughtworks.bookshelf.test;

/**
 * Created by tphuang on 5/11/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpHelper {
    public HttpHelper() {
    }

    public static String ReturnHTML(String html) {
        return html;
    }

    public static String getResponse (String urlToRead) {
        String result = "";

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader rd;
            String line;
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while((line = rd.readLine()) != null) {
                result += line;
            }

            rd.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return result;
    }

    public static String getResponseWithHttpGet(String url) {
        String result = "";
        HttpClient client = HttpClients.createDefault();
//        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try{
            HttpResponse response = client.execute(get);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        }catch (ClientProtocolException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getResponseWithHttpPost(HttpPost post) {
        String result = "";
        HttpClient client = HttpClients.createDefault();

        //设置post编码
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("id", "20"));
//        params.add(new BasicNameValuePair("name", "Lily"));
//        params.add(new BasicNameValuePair("status", "true"));
//
//        try{
//            post.setEntity(new UrlEncodedFormEntity(params));
//            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
//            post.setHeader("Content-Type", "application/json;charset=UTF-8");
//            HttpResponse response = client.execute(post);
//
//           if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//                result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            }
//        }catch (ClientProtocolException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}