package NIO.nio1120;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author: 小霸王
 * @Date: 2019/11/20 9:18
 */
public class NIO112001 {

    //客户端
    @Test
    public void client() {
        SocketChannel sc = null;
        FileChannel infc = null;
        //1、获取通道
        try {
            sc = SocketChannel.open(new InetSocketAddress("172.0.0.1",8989));
            infc = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
            //2、分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //3、读取本地文件，发送至服务器
            while (infc.read(byteBuffer) != -1){
                byteBuffer.flip();
                sc.write(byteBuffer);
                byteBuffer.clear();
            }
            System.out.println(" 客户端写入数据成功 ");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、关闭通道
            if (infc != null) {
                try {
                    infc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null){
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server(){
        ServerSocketChannel ssc = null;
        FileChannel outfc = null;
        try {
            //1、获取通道
            ssc = ServerSocketChannel.open();
            outfc = FileChannel.open(Paths.get("2.png"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);
            //2、绑定连接
            ssc.bind(new InetSocketAddress(8989));
            //3、获取客户端连接的通道
            SocketChannel sc = ssc.accept();
            //4、分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (sc.read(byteBuffer) != -1){
                byteBuffer.flip();
                outfc.write(byteBuffer);
                byteBuffer.clear();
            }
            System.out.println(" 服务端接受数据完成 ");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、关闭连接
            if (outfc != null){
                try {
                    outfc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ssc != null){
                try {
                    ssc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


}
