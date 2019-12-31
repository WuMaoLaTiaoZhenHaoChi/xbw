package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 9:33
 */
public class LightOffCommand implements Command {

    private LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void excute() {
        lightReceiver.lightOff();
    }

    @Override
    public void undo() {
        lightReceiver.lightOn();
    }
}
