package mode.memento.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 21:06
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //保存状态的方法
    public Memento saveStateMemeto(){
        return new Memento(state);
    }

    public void getStateFromMemeto(Memento memento){
        state = memento.getState();
    }

}
