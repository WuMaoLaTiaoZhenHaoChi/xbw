package java8.forkjoin1112;

import java8.lambda01.Employee;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author: 小霸王
 * @Date: 2019/11/12 9:42
 */
public class Test1112 {

    @Test
    public void test1(){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FrokJoin frokJoin = new FrokJoin(0, 100000000L);
        Long sum = forkJoinPool.invoke(frokJoin);
        System.out.println(sum);
    }

    @Test
    public void test2(){
        long sum = 0;
        for (long i = 0; i < 100000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void test3(){
        Instant start = Instant.now();
        long sum = LongStream.range(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println(" 时间： " + Duration.between(start,end).toMillis());
        System.out.println(sum);
    }

    @Test
    public void test4(){
        Optional<Employee> optional = Optional.ofNullable(new Employee("老王",25,5555.55));
        Employee employee = optional.get();
        System.out.println(employee);
    }

    @Test
    public void test5(){
        Man man = new Man(Optional.of(new Goddess("小王")));
        Optional<Man> optionalManman = Optional.of(man);
        String name = getName(optionalManman);
        System.out.println(name);
    }

    public String getName(Optional<Man> man){
        String name = man.orElse(new Man())
                .getGoddess()
                .orElse(new Goddess("小李"))
                .getName();
        return name;
    }

}
