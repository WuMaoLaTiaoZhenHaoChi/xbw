package mode.decorate.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/16 14:56
 */
public abstract class Drink {
    public String desc;
    private float price = 0.00f;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();

}
