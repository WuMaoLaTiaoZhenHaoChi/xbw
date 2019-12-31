package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 15:12
 */
public class Decorate extends Drink {
    Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return drink.cost() + super.getPrice();
    }

    @Override
    public String getDesc() {
        return desc + getPrice() + ": && " + drink.getDesc() ;
    }
}
