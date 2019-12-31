package mode.mediator.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/30 10:34
 */
public abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return this.mediator;
    }

    public abstract void sendMessage(int stateChange);
}
