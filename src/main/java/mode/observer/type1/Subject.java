package mode.observer.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 14:57
 */
public interface Subject {
    //注册
    public void registerObserver(Observer observer);
    //移除
    public void removeObserver(Observer observer);
    //通知
    public void notifyObserver();

}
