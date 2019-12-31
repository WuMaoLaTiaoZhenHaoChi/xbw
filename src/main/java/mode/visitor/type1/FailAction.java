package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:21
 */
public class FailAction extends Action {
    @Override
    public void getManGrade(Man man) {
        System.out.println(man.name + " 评分：10 ");
    }

    @Override
    public void getWomanGrade(Woman woman) {
        System.out.println(woman.name + " 评分：10 ");
    }
}
