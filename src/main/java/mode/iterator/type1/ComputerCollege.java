package mode.iterator.type1;

import java.util.Iterator;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:32
 */
public class ComputerCollege implements College {

    Department[] departments = new Department[10];
    int index = 0;

    public ComputerCollege(Department department) {
        addDepartment(department);
    }

    @Override
    public String getName() {
        return " 计算机学院 ";
    }

    @Override
    public void addDepartment(Department department) {
        departments[index++] = department;
    }

    @Override
    public Iterator creatIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
