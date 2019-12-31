package mode.Facade.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 10:38
 */
public class HomeFacade {

    private Screen screen = Screen.getScreen();
    private DvDPlayer dvDPlayer = DvDPlayer.getDvdPlayer();
    private LampLight lampLight = LampLight.getLampLight();

    public void start(){
        screen.down();
        dvDPlayer.start();
        lampLight.off();
    }

    public void pause(){
        dvDPlayer.pause();
    }

    public void off(){
        lampLight.off();
        dvDPlayer.off();
        screen.up();
    }

}
