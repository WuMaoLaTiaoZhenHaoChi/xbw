package mode.iterator.type1;

import java.util.Iterator;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 14:58
 */
public class ComputerCollegeIterator implements Iterator {

    Department[] departments;
    int index = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.length || departments[index] == null)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        Department department = departments[index];
        index += 1;
        return department;
    }

    @Override
    public void remove() {

    }
}
