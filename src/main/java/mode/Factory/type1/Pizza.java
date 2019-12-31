package mode.Factory.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/9/30 14:18
 */
public abstract class Pizza {

    private String name;

    public abstract void prepare();

    public void bake(){
        System.out.println(" 制作 " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
