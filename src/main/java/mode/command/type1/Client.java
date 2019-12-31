package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 10:00
 */
public class Client {
    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        RemoleCommand remoleCommand = new RemoleCommand();
        System.out.println(" ------------- ");
        remoleCommand.setCommands(0,lightOnCommand,lightOffCommand);
        remoleCommand.excuteOnButton(0);
        remoleCommand.excuteOffButton(0);
        remoleCommand.undo();

        System.out.println(" -------------- ");
        TVReceiver tvReceiver = new TVReceiver();
        remoleCommand.setCommands(1,new TVOnCommand(tvReceiver),new TVOffComand(tvReceiver));
        remoleCommand.excuteOnButton(1);
        remoleCommand.excuteOffButton(1);
        remoleCommand.excuteOnButton(0);
        remoleCommand.undo();
        remoleCommand.excuteOffButton(0);

    }
}
