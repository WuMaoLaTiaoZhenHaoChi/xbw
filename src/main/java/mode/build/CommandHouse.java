package mode.build;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 14:24
 */
public class CommandHouse {

    private BuildHouse buildHouse = null;

    public CommandHouse(BuildHouse buildHouse) {
        this.buildHouse = buildHouse;
    }

/*    public void setBuildHouse(BuildHouse buildHouse) {
        this.buildHouse = buildHouse;
    }*/

    public House getHouse(){
        buildHouse.buildFoundation();
        buildHouse.buildWall();
        buildHouse.buildRoof();
        return buildHouse.retHouse();
    }

}
