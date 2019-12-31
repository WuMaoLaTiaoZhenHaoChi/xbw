package mode.observer.type1;

import java.util.Calendar;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 15:11
 */
public class BaiduWeatherObserver implements Observer {

    private long temperature;//气温
    private long intensity;//压强
    private long humidity;//湿度

    @Override
    public void updateWeather(long temperature, long intensity, long humidity) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.HOUR_OF_DAY) + "时 百度天气 " + " 温度 " + temperature + " 气压 " + intensity + " 湿度 " + humidity);
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getIntensity() {
        return intensity;
    }

    public void setIntensity(long intensity) {
        this.intensity = intensity;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }
}
