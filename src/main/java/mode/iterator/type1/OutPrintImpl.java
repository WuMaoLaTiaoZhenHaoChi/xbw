package mode.iterator.type1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:44
 */
public class OutPrintImpl {

    List<College> collegeList = new ArrayList<College>();

    public OutPrintImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege(){
        Iterator<College> collegeIterator = collegeList.iterator();
        while (collegeIterator.hasNext()){
            College college = collegeIterator.next();
            System.out.println("========" + college.getName() + "=========");
            printDepartment(college.creatIterator());
        }
    }

    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department next = (Department) iterator.next();
            System.out.println(next.getName() + next.getDesc());
        }
    }

}
