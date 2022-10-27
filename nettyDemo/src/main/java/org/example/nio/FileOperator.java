package org.example.nio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @program: daydayup
 * @date: 2022/10/25
 * @author: gaorunding1
 * @description: 文件操作
 **/
public class FileOperator {
    public static void main(String[] args) throws IOException {
        test4();
    }


    /**
     * 测试两个file通过channel通过bytebuffer交互
     */
    private static void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("nettyDemo/1.txt");
        FileChannel channel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("nettyDemo/2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        int read;
        while ((read = channel1.read(byteBuffer)) != -1) {
            System.out.println(new String(byteBuffer.array(), 0, read));
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.clear();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 测试两个file通过channel直接交互
     */
    private static void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("nettyDemo/1.txt");
        FileChannel channel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("nettyDemo/2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();
        channel2.transferFrom(channel1, 0, new File("nettyDemo/1.txt").length());
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 测试两个file通过channel直接交互
     */
    private static void test3() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("nettyDemo/1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 8);
        map.put(0, (byte) 'H');
        map.put(7, (byte) '9');
        randomAccessFile.close();
    }

    /**
     * 测试多个buffer
     */
    private static void test4() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(7000));
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long length = socketChannel.read(byteBuffers);
                byteRead += length;
                System.out.println("byteRead=" + byteRead);
                Arrays.stream(byteBuffers).map(byteBuffer -> "position=" + byteBuffer.position() + ",limit=" + byteBuffer.limit()).forEach(System.out::println);
                //所有buffer flip
                Arrays.stream(byteBuffers).forEach(ByteBuffer::flip);
            }

            //数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long length = socketChannel.write(byteBuffers);
                byteWrite += length;
            }

            Arrays.stream(byteBuffers).forEach(ByteBuffer::clear);
            System.out.println("byteRead=" + byteRead + ",byteWrite=" + byteWrite + ",messageLength=" + messageLength);
        }
    }
}
