package java8.forkjoin1112;

/**
 * @Author: 小霸王
 * @Date: 2019/11/12 11:01
 */
public class Goddess {
    private String name;

    public Goddess() {
    }

    public Goddess(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Godess{" +
                "name='" + name + '\'' +
                '}';
    }
}
