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
 * @Date: 2019/11/20 14:04
 *
 * 阻塞式
 */
public class NIO112002 {

    //客户端
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
        FileChannel inFileChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);

        ByteBuffer dst = ByteBuffer.allocate(1024);

        while (inFileChannel.read(dst) != -1) {
            dst.flip();
            socketChannel.write(dst);
            dst.clear();
        }

        socketChannel.shutdownOutput();
        //读取服务端数据
        int len = 0;
        while ((len = socketChannel.read(dst)) != -1){
            dst.flip();
            System.out.println(new String(dst.array(), 0, len));
            dst.clear();
        }

        inFileChannel.close();
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outFileChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        serverSocketChannel.bind(new InetSocketAddress(8989));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer dst = ByteBuffer.allocate(1024);
        while (socketChannel.read(dst) != -1){
            dst.flip();
            outFileChannel.write(dst);
            dst.clear();
        }

        dst.put(" 客户端写入完毕 ".getBytes());
        dst.flip();
        socketChannel.write(dst);
        dst.clear();

        socketChannel.close();
        outFileChannel.close();
        serverSocketChannel.close();
    }

}
