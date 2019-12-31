package mode.command.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/24 9:25
 * 命令模式
 */
public interface Command {

    //操作
    public void excute();

    //撤销
    public void undo();

}
