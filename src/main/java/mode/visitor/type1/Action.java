package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:12
 * 访问者模式
 */
public abstract class Action {

    //男性观众评分
    public abstract void getManGrade(Man man);

    //女性观众评分
    public abstract void getWomanGrade(Woman woman);

}
