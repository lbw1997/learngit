package com.company.sourcecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BIOServer {
    public void initBIOServer(int port) {
        ServerSocket serverSocket = null;//服务端
        Socket socket = null;//客户端
        BufferedReader bufferedReader = null;
        int count = 0;
        String inputContent;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(stringNowTime() + ":id为" + socket.hashCode()+"的Clientsocket connected");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((inputContent = bufferedReader.readLine())!=null) {
                System.out.println("收到的id为："+socket.hashCode()+" "+inputContent);
                count++;
            }
            System.out.println("id为："+socket.hashCode()+"的Clientsocket"+stringNowTime()+"读取结束");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String stringNowTime() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(new Date());
    }
    public static void main(String[] args) {
        BIOServer bioServer = new BIOServer();
        bioServer.initBIOServer(8888);
    }
}
