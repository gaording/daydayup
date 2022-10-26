package org.example.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: daydayup
 * @date: 2022/10/25
 * @author: gaorunding1
 * @description: 文件操作
 **/
public class FileOperator {
    public static void main(String[] args) throws IOException {
        test3();
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
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0,8 );
        map.put(0,(byte) 'H');
        map.put(7,(byte) '9');
        randomAccessFile.close();
    }
}
