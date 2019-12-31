package mode.build;

/**
 * @Author: DuanTong
 * @Date: 2019/10/11 14:26
 */
public class Cilent {

    public static void main(String[] args) {
        BuildHouse buildHouse = new BuildCommonHouse();
        BuildHouse buildHouse1 = new BulidLuxuryHouse();

        CommandHouse commandHouse = new CommandHouse(buildHouse1);

        House house = commandHouse.getHouse();
    }
}
