package NIO.nio1121;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: 小霸王
 * @Date: 2019/11/21 9:10
 *
 * 非阻塞式
 */
public class NIO112101 {

    public static void main(String[] args) throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //分配缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        //写入数据
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
/*        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.clear();*/
        //关闭通道
        socketChannel.close();
    }

    //客户端
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8989));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //分配缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        //写入数据
/*        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }*/
        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
        //关闭通道
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //开启阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8989));
        //获取选择器
        Selector selector = Selector.open();
        //绑定
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0){
            //获取所有key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //迭代器
            Iterator<SelectionKey> keys = selectionKeys.iterator();
            while (keys.hasNext()){
                SelectionKey key = keys.next();
                //如果是读数据模式
                if (key.isAcceptable()){
                    //若接受状态就绪
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //切换阻塞模式
                    socketChannel.configureBlocking(false);
                    //注册进选择器
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } else if (key.isReadable()){
                    //获取客户端通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //指定缓冲区
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                keys.remove();
            }
        }
        serverSocketChannel.close();
    }


}
