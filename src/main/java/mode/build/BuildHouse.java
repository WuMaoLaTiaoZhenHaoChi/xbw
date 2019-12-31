package mode.build;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 14:17
 */
public abstract class BuildHouse {

    private House house = new House();

    protected abstract void buildFoundation();

    protected abstract void buildWall();

    protected abstract void buildRoof();

    protected House retHouse(){
        return house;
    }

}
