package org.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: daydayup
 * @date: 2022/10/25
 * @author: gaorunding1
 * @description: 文件操作(测试两个file通过channel通过bytebuffer交互)
 **/
public class FileOperator {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("nettyDemo/1.txt");
        FileChannel channel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("nettyDemo/2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        int read;
        while ((read = channel1.read(byteBuffer)) != -1) {
            System.out.println(new String(byteBuffer.array(),0,read));
            byteBuffer.flip();
            channel2.write(byteBuffer);
            byteBuffer.clear();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
