package mode.iterator.type1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DuanTong
 * @Date: 2019/10/28 15:59
 */
public class Client {

    public static void main(String[] args) {
        Department comDepartment1 = new Department(" 计算机科学与技术01 ", " 计算机科学与技术desc01 ");
        Department comDepartment2 = new Department(" 计算机科学与技术02 ", " 计算机科学与技术desc02 ");
        Department comDepartment3 = new Department(" 计算机科学与技术03 ", " 计算机科学与技术desc03 ");

        Department infoDepartment1 = new Department(" 电子信息工程01 ", " 电子信息工程desc01 ");
        Department infoDepartment2 = new Department(" 电子信息工程02 ", " 电子信息工程desc02 ");
        Department infoDepartment3 = new Department(" 电子信息工程03 ", " 电子信息工程desc03 ");

        ComputerCollege computerCollege = new ComputerCollege(comDepartment1);
        computerCollege.addDepartment(comDepartment2);
        computerCollege.addDepartment(comDepartment3);

        InfoCollege infoCollege = new InfoCollege(infoDepartment1);
        infoCollege.addDepartment(infoDepartment2);
        infoCollege.addDepartment(infoDepartment3);

        List<College> collegeList = new ArrayList<>();
        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutPrintImpl outPrint = new OutPrintImpl(collegeList);
        outPrint.printCollege();

    }

}
