package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 15:04
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
