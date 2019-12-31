package mode.prototype.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/10 14:37
 */
public class TestDog {

    public static void main(String[] args) throws CloneNotSupportedException {
        Dog dog1 = new Dog("小黄",3);
        dog1.frend = new Dog("小黑",1);

        Dog dog2 = (Dog)dog1.clone();
        Dog dog3 = (Dog)dog1.clone();

        System.out.println("dog1=" + dog1.frend + dog1.frend.hashCode());
        System.out.println("dog2=" + dog2.frend + dog2.hashCode());
        System.out.println("dog3=" + dog3.frend + dog3.hashCode());

    }

}
