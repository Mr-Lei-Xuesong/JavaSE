package com.demo3.test2;

import java.io.*;
import java.net.Socket;

public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket s = new Socket("192.168.56.1", 10020);

        //键盘录入，知道输入886结束
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();
    }
}
