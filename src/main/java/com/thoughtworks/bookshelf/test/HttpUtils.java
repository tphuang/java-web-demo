package com.thoughtworks.bookshelf.test;

/**
 * Created by tphuang on 5/11/15.
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 接收path服务器端返回的 InputStream, 转换为 json字符串
 *
 * @author ben
 */
public class HttpUtils {
    public static String getJsonContent(String url_path) {
        String jsonString = "";
        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);  //从服务器获得数据

            int responseCode = connection.getResponseCode();
            if (200 == responseCode) {
                jsonString = changeInputStream(connection.getInputStream());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        return jsonString;
    }

    private static String changeInputStream(InputStream inputStream) throws IOException {
        String jsonString = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }

        jsonString = new String(outputStream.toByteArray(), "UTF-8");
        inputStream.close();

        return jsonString;
    }

}

