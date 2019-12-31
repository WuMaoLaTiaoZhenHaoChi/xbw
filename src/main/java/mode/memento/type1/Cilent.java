package mode.memento.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 21:24
 */
public class Cilent {

    public static void main(String[] args) {
        Originator originator = new Originator();


        Caretaker caretaker = new Caretaker();
        originator.setState(" 打怪物之前， 100% ");
        caretaker.addMenento(1,originator.saveStateMemeto());

        originator.setState(" 打怪物时候， 50% ");
        caretaker.addMenento(2,originator.saveStateMemeto());

        originator.setState(" 打怪物之后， 80% ");
        caretaker.addMenento(3,originator.saveStateMemeto());

        Memento memento = caretaker.getMenento(2);
        originator.getStateFromMemeto(caretaker.getMenento(1));
        System.out.println(memento.getState());

    }
}
