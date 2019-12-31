package mode.Facade.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 10:23
 */
public class DvDPlayer {
    private final static DvDPlayer DV_D_PLAYER = new DvDPlayer();

    private DvDPlayer() {

    }

    public static DvDPlayer getDvdPlayer() {
        return DV_D_PLAYER;
    }

    public void start(){
        System.out.println(" 打开DVD ");
    }

    public void pause(){
        System.out.println(" 暂停DVD ");
    }

    public void off(){
        System.out.println(" 关闭DVD ");
    }
}
