package NIO.nio1118;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: 小霸王
 * @Date: 2019/11/18 11:04
 */
public class NIO111802 {


    @Test
    public void test1(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("src"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("dst"));
            FileChannel inputStreamChannel = fileInputStream.getChannel();
            FileChannel outputStreamChannel = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true){
                int read = inputStreamChannel.read(byteBuffer);
                if (read <= 0)
                    break;
                byteBuffer.reset();
                outputStreamChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            outputStreamChannel.close();
            inputStreamChannel.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
        }
    }

}
