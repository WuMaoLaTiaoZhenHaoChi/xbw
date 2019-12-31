package mode.memento.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 21:07
 *
 * 备忘录模式
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveMemento(){
        return new Memento(state);
    }

}
