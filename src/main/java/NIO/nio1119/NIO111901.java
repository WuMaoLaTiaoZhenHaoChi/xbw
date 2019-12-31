package NIO.nio1119;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * @Author: 小霸王
 * @Date: 2019/11/19 9:20
 *
 * 获取通道：
 * 1、针对支持通道的类提供了getChannel方法
 * 2、NIO.2 针对各个通道提供了静态方法open()
 * 3、NIO.2 针对Files工具类的newByteChannel()
 */
public class NIO111901 {


    //通道之间数据传输
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

        //inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());

        outChannel.close();
        inChannel.close();
    }

    //利用直接缓冲区进行
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dsts = new byte[inMap.limit()];
        inMap.get(dsts);
        outMap.put(dsts);

        outChannel.close();
        inChannel.close();

    }

    //利用通道完成复制文件
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            fis = new FileInputStream("1.png");
            fos = new FileOutputStream("2.png");

            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();

            ByteBuffer dst = ByteBuffer.allocate(1024);
            while (fisChannel.read(dst) != -1){
                dst.flip();
                fosChannel.write(dst);
                dst.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fosChannel != null) {
                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fisChannel != null) {
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
