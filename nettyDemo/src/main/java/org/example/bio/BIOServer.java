package org.example.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: daydayup
 * @date: 2022/10/23
 * @author: gaorunding1
 * @description: bio server
 **/
public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池机制
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了....");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("连接到客户端...." + socket.getInetAddress()+socket.getPort());

            //创建一个线程进行通信
            cachedThreadPool.execute(() -> {
                //可以和客户端通信
                handle(socket);
            });
        }
    }

    public static void handle(Socket socket) {
        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
//            System.out.println("关闭与客户端" + socket.getInetAddress() + "的连接");
//            try {
//                socket.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
