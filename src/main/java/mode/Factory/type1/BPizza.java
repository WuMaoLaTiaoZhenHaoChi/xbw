package mode.Factory.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/9/30 14:31
 */
public class BPizza extends Pizza {
    
    @Override
    public void prepare() {
        System.out.println("准备 B Pizza的原材料！");
    }

}
