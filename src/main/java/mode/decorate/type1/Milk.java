package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 15:19
 */
public class Milk extends Decorate {
    public Milk(Drink drink) {
        super(drink);
        setDesc(" 加牛奶 ");
        setPrice(2.00f);
    }
}
