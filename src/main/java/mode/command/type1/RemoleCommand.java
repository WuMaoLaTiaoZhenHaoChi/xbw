package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 9:37
 */
public class RemoleCommand {

    Command[] onCommands;
    Command[] offCommands;

    Command signCommand;

    public RemoleCommand() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0;i < 5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommands(int n, Command onCommand, Command offCommadn){
        onCommands[n] = onCommand;
        offCommands[n] = offCommadn;
    }

    public void excuteOnButton(int n){
        onCommands[n].excute();
        signCommand = onCommands[n];
    }

    public void excuteOffButton(int n){
        offCommands[n].excute();
        signCommand = offCommands[n];
    }

    public void undo(){
        signCommand.undo();
    }

}
