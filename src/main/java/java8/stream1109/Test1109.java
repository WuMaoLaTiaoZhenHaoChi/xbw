package java8.stream1109;

import java8.lambda01.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: 小霸王
 * @Date: 2019/11/09 10:19
 *
 * Stream的三个操作步骤
 */
public class Test1109 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 33, 3333.33),
            new Employee("李四", 44, 4444.44),
            new Employee("王五", 55, 5555.55),
            new Employee("赵六", 66, 6666.66),
            new Employee("赵六", 66, 6666.66),
            new Employee("赵六", 66, 6666.66),
            new Employee("田七", 77, 7777.77)
    );

    //创建Stream
    @Test
    public void test1(){
        int[] ints = {1,2,3,4,5};

        //1、Collection的stream()或parallelStream
        Stream<Integer> stream = new ArrayList<Integer>().stream();
        Stream<Integer> stream1 = new ArrayList<Integer>().parallelStream();

        //2、Arrays.Stm()
        IntStream stream2 = Arrays.stream(ints);

        //3、Strea类中的静态方法
        Stream<int[]> stream3 = Stream.of(ints);

        //4、创建无限流
        Stream<Integer> stream4 = Stream.iterate(2,(x) -> 2 + x);
        stream4.limit(5).forEach(System.out::println);

        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(5).forEach(System.out::println
        );
    }
    /*
     * 中间操作
     * filter：过滤
     * limit：截断
     * skip：跳过元素
     * distinc：去重
     */
    @Test
    public void test2(){
        Stream<Employee> limit = employees.stream()
                .filter((e) -> {
                    //System.out.println(" 短路 ");
                    return e.getSalary() > 5000;
                })
                .limit(10)
                .skip(1)
                .distinct();
        limit.forEach(System.out::println);
    }

    /**
     * 映射
     * map：接收lambda将元素转换成其他像是或提供信息
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */
    @Test
    public void test3(){
        List<String> strList = Arrays.asList("aaa","bbb","ccc","dddd");

        strList.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        System.out.println(" --------------- ");

/*        Stream<Stream<Character>> streamStream = strList.stream()
                .map(Test1109::filterCharacter);

        streamStream.forEach((charStream) ->
                charStream.map((c) -> c)
                .forEach(System.out::println)
        );*/

        Stream<Character> characterStream = strList.stream()
                .flatMap(Test1109::filterCharacter);
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str){
        ArrayList<Character> list = new ArrayList<>();

        for (char c : str.toCharArray())
            list.add(c);
        return list.stream();
    }

    /**
     * 排序
     * sorted():自然排序
     */
    @Test
    public void test5(){
        List<String> strList = Arrays.asList("aaa","bbb","ccc","dddd");
        strList.stream()
                .sorted()
                .forEach(System.out::println);

        //定制排序
        employees.stream()
                .sorted((e1,e2) -> {
                    if (e1.getAge() == e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else
                        return (e1.getAge() - e2.getAge());
                })
                .forEach(System.out::println);
    }

}
