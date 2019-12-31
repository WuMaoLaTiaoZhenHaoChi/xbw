package mode.composite.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 10:59
 */
public class Cilent {

    public static void main(String[] args) {
        Specialty specialty1 = new Specialty("计算机科学与技术", "good！");
        Specialty specialty2 = new Specialty("应用物理", "good！");

        Specialty specialty3 = new Specialty("语文", "good！");
        Specialty specialty4 = new Specialty("外语", "good！");

        College college = new College("电子与信息工程", "Big");
        College college2 = new College("教育学院", "Big");

        college.add(specialty1);
        college.add(specialty2);
        //college.print();

        college2.add(specialty3);
        college2.add(specialty4);

        University university = new University("清华大学", "一流的");
        university.add(college);
        university.add(college2);
        //university.print();
        university.print();

    }

}
