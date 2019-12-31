package java8.forkjoin1112;

import java.util.Optional;

/**
 * @Author: 小霸王
 * @Date: 2019/11/12 11:02
 */
public class Man {
    private Optional<Goddess> goddess = Optional.empty();

    public Man() {
    }

    public Man(Optional<Goddess> goddess) {
        this.goddess = goddess;
    }

    public Optional<Goddess> getGoddess() {
        return goddess;
    }

    public void setGoddess(Optional<Goddess> goddess) {
        this.goddess = goddess;
    }

    @Override
    public String toString() {
        return "Man{" +
                "goddess=" + goddess +
                '}';
    }
}
