package mode.Facade;

/**
 * @Author: DuanTong
 * @Date: 2019/8/29 16:51
 *
 * 外观模式：
 *  外观模式是为了解决类与类之家的依赖关系的，
 *  像spring一样，可以将类和类之间的关系配置
 *  到配置文件中，而外观模式就是将他们的关系放
 *  在一个Facade类中，降低了类类之间的耦合度，
 */
public class Animals {

    private Cat cat;
    private Dog dog;

    public Animals() {
        this.dog = new Dog();
        this.cat = new Cat();
    }

    public void eat(){
        System.out.println("eat before...");
        cat.eat();
        dog.eat();
        System.out.println("eat after...");

    }

    protected void play(){
        System.out.println("play befor...");
        cat.play();
        dog.play();
        System.out.println("play after...");
    }

}
