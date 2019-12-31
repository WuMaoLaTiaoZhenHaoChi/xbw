package mode.build;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 14:58
 */
public class BulidLuxuryHouse extends BuildHouse {
    @Override
    protected void buildFoundation() {
        System.out.println(" 给普通房子打地基50m ");
    }

    @Override
    public void buildWall() {
        System.out.println(" 给高楼子盖墙20cm ");
    }

    @Override
    public void buildRoof() {
        System.out.println(" 给高楼加屋顶 ");
    }

    @Override
    public House retHouse() {
        System.out.println(" 建造一栋高楼 ");
        House house = super.retHouse();
        return house;
    }
}
