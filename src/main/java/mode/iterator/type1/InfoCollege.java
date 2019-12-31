package mode.iterator.type1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:35
 */
public class InfoCollege implements College {
    List<Department> departmentList = new ArrayList<Department>();

    public InfoCollege(Department department) {
        addDepartment(department);
    }

    @Override
    public String getName() {
        return " 电子信息学院 ";
    }

    @Override
    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    @Override
    public Iterator creatIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
