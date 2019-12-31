package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 10:05
 */
public class TVOnCommand implements Command {
    private TVReceiver tvReceiver;

    public TVOnCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void excute() {
        tvReceiver.tvOn();
    }

    @Override
    public void undo() {
        tvReceiver.tvOff();
    }
}
