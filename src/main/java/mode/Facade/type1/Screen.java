package mode.Facade.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 10:13
 */
public class Screen {

    private final static Screen SCREEN = new Screen();

    private Screen() {

    }

    public static Screen getScreen() {
        return SCREEN;
    }

    public void up(){
        System.out.println(" 屏幕升上去 ");
    }
    public void down(){
        System.out.println(" 屏幕降下来 ");
    }

}
