package mode.Facade.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/18 10:33
 */
public class LampLight {

    private static final LampLight LAMP_LIGHT = new LampLight();

    private LampLight() {
    }

    public static LampLight getLampLight() {
        return LAMP_LIGHT;
    }

    public void open(){
        System.out.println(" 打开灯光 ");
    }

    public void off(){
        System.out.println(" 关闭灯光 ");
    }
}
