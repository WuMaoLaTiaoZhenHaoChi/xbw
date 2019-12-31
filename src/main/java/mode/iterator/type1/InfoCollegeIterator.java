package mode.iterator.type1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:04
 */
public class InfoCollegeIterator implements Iterator {

    List<Department> departmentList = new ArrayList<Department>();
    int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1)
            return false;
        else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
