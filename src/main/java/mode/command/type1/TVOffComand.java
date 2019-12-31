package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 10:08
 */
public class TVOffComand implements Command {
    private TVReceiver tvReceiver;

    public TVOffComand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void excute() {
        tvReceiver.tvOff();
    }

    @Override
    public void undo() {
        tvReceiver.tvOn();
    }
}
