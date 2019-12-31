package mode.observer.type1;

import java.util.ArrayList;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 15:00
 */
public class WeatherSubject implements Subject {

    private long temperature;//气温
    private long intensity;//压强
    private long humidity;//湿度

    private ArrayList<Observer> observerList = new ArrayList<>();

    public void setWeather(long temperature, long intensity, long humidity){
        this.temperature = temperature;
        this.intensity = intensity;
        this.humidity = humidity;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer))
            observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList){
            observer.updateWeather(this.temperature,this.intensity,this.humidity);
        }
    }

}
