package mode.template.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/23 14:59
 */
public class Client {

    public static void main(String[] args) {
        MakeSoybean soybean = new OrmosiaSoybean();
        //soybean.make();

        MakeSoybean soybean1 = new OriginalSoybean();
        soybean1.make();
    }

}
