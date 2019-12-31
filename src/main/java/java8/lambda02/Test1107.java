package java8.lambda02;

import java8.lambda01.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 11:15
 */
public class Test1107 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 33, 3333.33),
            new Employee("李四", 44, 4444.44),
            new Employee("王五", 55, 5555.55),
            new Employee("赵六", 66, 6666.66),
            new Employee("田七", 77, 7777.77)
    );

    //Consumer<T> : 消费型接口
    public void consumerTest(String str, Consumer consumer) {
        consumer.accept(str);
    }

    @Test
    public void test1() {
        consumerTest(" Hello Lambda ", (str) -> System.out.println(str));
    }

    //Supplier<T> : 供给型接口
    public List<Integer> supplierTest(Supplier supplier) {
        return (List<Integer>) supplier.get();
    }

    @Test
    public void test2() {
        List<Integer> retList = new ArrayList<>();
        retList = supplierTest(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add((int) (Math.random() * 100));
            }
            return list;
        });
        System.out.println(retList);
    }

    //Function<T, R> : 函数型接口
    public List<Employee> functionTest(List<Employee> employees, Function<List<Employee>, List<Employee>> function) {
        return (List<Employee>) function.apply(employees);
    }

    @Test
    public void test3() {
        List<Employee> es = functionTest(employees, (emps) -> {
            List<Employee> employeeList = new ArrayList<>();
            for (Employee employee : emps) {
                if (employee.getAge() > 50)
                    employeeList.add(employee);
            }
            return employeeList;
        });
        System.out.println(es);
    }

    // Predicate<T> : 断言型接口
    public boolean predicateTest(Employee employee, Predicate<Employee> predicate){
        return predicate.test(employee);
    }

    @Test
    public void test4(){
        List<Employee> empleList = new ArrayList<>();
        for (Employee employee : employees){
            if(predicateTest(employee,(emp) -> emp.getAge() > 60))
                empleList.add(employee);
        }
        System.out.println(empleList);
    }



}
