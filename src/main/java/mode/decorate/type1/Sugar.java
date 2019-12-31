package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 15:16
 */
public class Sugar extends Decorate {

    public Sugar(Drink drink) {
        super(drink);
        setDesc(" 加糖 ");
        setPrice(1.50f);
    }

}
