package com.thoughtworks.bookshelf.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 * Created by tphuang on 5/11/15.
 */
public class TestJSONClient {

    public static String webRoot = "http://localhost:8081/java-web-demo/person/";

    public static String handleProfileUrl() {
        String query = "id="
                + 100
                + "&name="
                + URLEncoder.encode("hello &/world")
                + "&status="
                + true;
        String url = webRoot + "myprofile?" + query;
        return url;
    }

    public static HttpPost handleHttpPost(String url, String params) {
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(params);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        stringEntity.setContentType("application/json");
        post.setEntity(stringEntity);
        return post;
    }

    public static void main(String[] args) {

//        String get = HttpHelper.getResponse(url);
        String get = HttpHelper.getResponseWithHttpGet(handleProfileUrl());

        String params = "{'id':'20','name':'Helen','status':'true'}";
        String post = HttpHelper.getResponseWithHttpPost(handleHttpPost(webRoot + "login.do", params));

        System.out.println("The get is: " + get);
        System.out.println("The post is: " + post);
    }
}
