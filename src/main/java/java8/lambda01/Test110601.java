package java8.lambda01;

import org.junit.Test;

import java.util.*;

/**
 * @Author: 小霸王
 * @Date: 2019/11/6 9:09
 */
public class Test110601 {

    //普通匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    //lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> comparator = (x1,x2) -> Integer.compare(x1,x2);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    public List<Employee> employees = Arrays.asList(
            new Employee("张三",33,3333.33),
            new Employee("李四",44,4444.44),
            new Employee("王五",55,5555.55),
            new Employee("赵六",66,6666.66),
            new Employee("田七",77,7777.77)
    );

    //获取当前员工年龄大于30
    public List<Employee> filterByAge(List<Employee> employees){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getAge() > 50)
                employeeList.add(employee);
        }
        return employeeList;
    }

    //简单粗暴
    @Test
    public void test3(){
        List<Employee> employeeList = filterByAge(employees);
        for (Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }

    //实现接口完成过滤,优化1
    public List<Employee> filterBySalary(List<Employee> employees, FilterEmployee filterEmployee){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees){
            if (filterEmployee.filterBySomething(employee))
                employeeList.add(employee);
        }
        return employeeList;
    }

    @Test
    public void test4(){
        List<Employee> employeeList = filterBySalary(employees,new SalaryFilterEmployee());
        for (Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }

    //内部类，优化2
    @Test
    public void test5(){
        List<Employee> employeeList = filterBySalary(employees, new FilterEmployee() {
            @Override
            public boolean filterBySomething(Employee employee) {
                return employee.getSalary() < 4000;
            }
        });
        for (Employee employee : employeeList){
            System.out.println(employee.toString());
        }
    }

    //优化3，lambda表达式
    @Test
    public void test6(){
        List<Employee> employeeList = filterBySalary(employees,(e) -> e.getSalary() > 6000);
        employeeList.forEach(System.out::println);
    }

    //优化4，
    @Test
    public void test7(){
        System.out.println(" ------------------- ");
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println(" ------------------- ");
    }

}
