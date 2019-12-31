package mode.template.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/23 14:50
 */
abstract public class MakeSoybean {

    final void make(){
        start();
        if (isAdd()){
            add();
        }
        end();
    }

    void start(){
        System.out.println(" 准备原料 ");
    }

    abstract void add();

    void end(){
        System.out.println(" 制作完成 ");
    }

    //钩子函数
    boolean isAdd(){
        return true;
    }

}
