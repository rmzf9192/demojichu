package com.el.jichu.io.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * @author roman zhangfei
 * @Date 2019/12/27 9:45
 * @Version V1.0
 */
public class TCPSendTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.17.86.214", 7070);

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        outputStream.writeUTF("你好啊，小子，想挨揍吗？");
    }
}