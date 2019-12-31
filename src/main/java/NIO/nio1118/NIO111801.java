package NIO.nio1118;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Author: 小霸王
 * @Date: 2019/11/18 9:14
 *
 * 一、缓冲区（Buffer）：在java的NIO中负责数据的存取，缓冲区就是数组，用于储存不同数据类型的数据
 * ByterBuffer
 * CharBuffer
 * shortBuffer
 * IntBuffer
 * FloatBuffer
 * LongBuffer
 * DoubleBuffer
 *
 *二、缓冲区存取数据的两个核心方法
 * put()：存入数据到缓冲区中
 * get()：获取缓冲区中的数据
 *
 * 四、缓冲区的四个核心属性：
 * capacity：容量，表示缓冲区最大存储数据的容量，一旦声明不能改变
 * limit：界限，表示缓冲区可以操作数据的大小。（limit之后的数据不能进行读写）
 * position：位置，表示缓冲区正在操作数据的位置
 *
 * mark：标记，表示记录当前position的位置。可以通过reset()恢复到记录的位置
 */
public class NIO111801 {

    @Test
    public void test2(){
        byte[] bytes = new String("abcde").getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(bytes);
        System.out.println(byteBuffer.position());
        System.out.println(" ------------------ ");

        byteBuffer.flip();
        System.out.println(" ------------------ ");
        System.out.println(byteBuffer.position());

        //byteBuffer.mark();
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst,0,1);
        System.out.println(new String(dst));
        System.out.println(byteBuffer.position());
        System.out.println(" ------------------ ");

        //byteBuffer.reset();
        byteBuffer.get(dst,0,1);
        System.out.println(new String(dst));
        byteBuffer.mark();
        System.out.println(byteBuffer.position());
        System.out.println(" ------------------ ");

/*        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst));*/

    }

    @Test
    public void test1(){
        byte[] bytes = new String("abcde").getBytes();
        //分配一个指定大小的缓冲区  -allocate()-
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");

        //存入数据据到缓冲区中 -put()-
        byteBuffer.put(bytes,0,2);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");

        //切换到读数据模式 -flip()-
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");


        //读取缓冲区的数据  -get()-
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");

        //可重复读取 -rewind()-
        byteBuffer.rewind();
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");

        //清空缓冲区，但是缓冲区中的数据依旧存在，缓冲区的数据处于“被遗忘”状态 -clear()-
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(" ------------------ ");

    }


}
