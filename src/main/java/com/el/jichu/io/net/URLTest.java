package com.el.jichu.io.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 10:16
 * @Version V1.0
 */
public class URLTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI uri = new URI("https://www.baidu.com/");
        URL url1 = uri.toURL();
        InputStream inputStream = url1.openStream();
        System.out.println(inputStream.read());

        while(true) {
            URL url = new URL("https://tw.elitesland.com/user/timesheet/detail");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println(connection.getResponseCode());
            byte[] bytes = new byte[100];

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lineString = null;
            while ((lineString = bufferedReader.readLine()) != null) {
                stringBuffer.append(lineString);
            }
            System.out.println(stringBuffer.toString());
        }
    }
}