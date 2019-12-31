package mode.visitor.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/25 10:29
 */
public class Cilent {
    public static void main(String[] args) {
        SuccessAction successAction = new SuccessAction();
        FailAction failAction = new FailAction();

        Man man1 = new Man("小王");
        Man man2 = new Man("小李");
        Woman woman1 = new Woman("小红");

        ObjectStructure structure = new ObjectStructure();
        structure.attach(man1);
        structure.attach(man2);
        structure.attach(woman1);
        structure.display(successAction);
        structure.display(failAction);

    }
}
