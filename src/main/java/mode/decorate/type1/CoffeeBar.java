package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 15:22
 */
public class CoffeeBar {

    public static void main(String[] args) {
        Drink coffee01 = new Coffee01();
        System.out.println(" Coffee描述 " + coffee01.getDesc());
        System.out.println(" Coffee价格 " + coffee01.cost());
        System.out.println("   --------------------   ");

        coffee01 = new Sugar(coffee01);
        System.out.println(" Coffee01 + Suger " + coffee01.getDesc());
        System.out.println(" Coffee01 + Suger " + coffee01.cost());
        System.out.println("   --------------------   ");

        coffee01 = new Milk(coffee01);
        System.out.println(" Coffee01 + Suger " + coffee01.getDesc());
        System.out.println(" Coffee01 + Suger " + coffee01.cost());
        System.out.println("   --------------------   ");

    }

}
