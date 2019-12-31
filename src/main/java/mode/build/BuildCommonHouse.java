package mode.build;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 14:21
 */
public class BuildCommonHouse extends BuildHouse {
    @Override
    public void buildFoundation() {
        System.out.println(" 给普通房子打地基5m ");
    }

    @Override
    public void buildWall() {
        System.out.println(" 给普通房子盖墙10cm ");
    }

    @Override
    public void buildRoof() {
        System.out.println(" 给普通房子加屋顶 ");
    }

    @Override
    public House retHouse() {
        System.out.println(" 建造一栋普通房子 ");
        House house = super.retHouse();
        return house;
    }
}
