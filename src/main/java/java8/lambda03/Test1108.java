package java8.lambda03;

import java8.lambda01.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: 小霸王
 * @Date: 2019/11/8 9:12
 */
public class Test1108 {

    //实例::实例方法
    @Test
    public void test01(){
        Consumer<String> con = (str) -> System.out.println(str);
        con.accept(" System.out.println(str) ");

        Consumer<String> consumer = System.out::println;
        consumer.accept(" System.out::println ");
    }

    //类::静态方法
    @Test
    public void test02(){
        BiFunction<Integer,Integer,Integer> biFunction = (x,y) -> Integer.compare(x,y);
        int i = biFunction.apply(3,5);
        System.out.println(i);

        BiFunction<Integer,Integer,Integer> biFunction1 = Integer::compareTo;
        System.out.println(biFunction1.apply(3,5));
    }

    //类：实例方法
    @Test
    public void test03(){
        BiPredicate<String,String> biPredicate = (str1,str2) -> str1.equals(str2);
        System.out.println(biPredicate.test("hello","hello"));

        BiPredicate<String,String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("hello","hello"));
    }

    //构造器
    @Test
    public void test04(){
        Function<String , Employee> function = (name) -> new Employee(name);
        Employee employee = function.apply("老王");
        System.out.println(employee.toString());

        Function<String,Employee> function1 = Employee::new;
        Employee employee1 = function1.apply("老张");
        System.out.println(employee1.getName());

    }

}
