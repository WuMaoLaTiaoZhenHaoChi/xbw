package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 9:31
 */
//打开台灯
public class LightOnCommand implements Command {

    private LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void excute() {
       lightReceiver.lightOn();
    }

    @Override
    public void undo() {
        lightReceiver.lightOff();
    }
}
