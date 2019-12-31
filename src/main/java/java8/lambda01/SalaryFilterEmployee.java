package java8.lambda01;

/**
 * @Author: 小霸王
 * @Date: 2019/11/6 15:00
 */
public class SalaryFilterEmployee implements FilterEmployee {
    @Override
    public boolean filterBySomething(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
