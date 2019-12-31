package mode.prototype.type2;

/**
 * @Author: DuanTong
 * @Date: 2019/10/10 15:09
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        ClonePrototypeClass clonePrototypeClass1 = new ClonePrototypeClass();
        clonePrototypeClass1.clonePrototype = new ClonePrototype("AAA","BBB");

        //重新clone方法实现原型模式
        ClonePrototypeClass clonePrototypeClass2 = (ClonePrototypeClass) clonePrototypeClass1.clone();
        //输入输出流实现原型模式
        ClonePrototypeClass clonePrototypeClass3 = (ClonePrototypeClass) clonePrototypeClass1.myClone();


        System.out.println("c1 = " + clonePrototypeClass1.hashCode());
        System.out.println("c2 = " + clonePrototypeClass2.hashCode());
        System.out.println("c3 = " + clonePrototypeClass3.hashCode());

    }

}
