package mode.composite.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/17 10:18
 */
public abstract class Composition {
    private String des;
    private String name;

    public Composition(String name, String des) {
        super();
        this.des = des;
        this.name = name;
    }

    //打印
    protected abstract void print();

    //添加
    protected void add(Composition composition){
        throw new UnsupportedOperationException();
    }

    //移除
    protected void remove(Composition composition){
        throw new UnsupportedOperationException();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
