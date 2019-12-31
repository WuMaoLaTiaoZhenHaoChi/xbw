package mode.iterator.type1;

import java.util.Iterator;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:10
 */
public interface College {

    public String getName();

    //增加系
    public void addDepartment(Department department);

    //遍历
    public Iterator creatIterator();

}
