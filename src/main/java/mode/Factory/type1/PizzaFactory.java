package mode.Factory.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/9/30 14:29
 */
public class PizzaFactory {
    private Pizza pizza = null;
    public Pizza getPizza(String name){
        if (name == "A"){
            pizza = new APizza();
            pizza.setName("A");
            pizza.prepare();
            pizza.bake();
        }else if (name == "B"){
            pizza = new BPizza();
            pizza.setName("B");
            pizza.prepare();
            pizza.bake();
        }else {
            System.out.println("没有此披萨！");
        }
        return pizza;
    }

}
