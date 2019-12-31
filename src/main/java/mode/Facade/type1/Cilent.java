package mode.Facade.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 10:41
 */
public class Cilent {

    public static void main(String[] args) {
        HomeFacade homeFacade = new HomeFacade();
        homeFacade.start();
        homeFacade.pause();
        homeFacade.off();
    }

}
