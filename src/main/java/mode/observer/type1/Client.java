package mode.observer.type1;

/**
 * @Author: DuanTong
 * @Date: 2019/10/29 15:21
 */
public class Client {

    public static void main(String[] args) {
        BaiduWeatherObserver baiduWeatherObserver = new BaiduWeatherObserver();

        WeatherSubject weatherSubject = new WeatherSubject();
        weatherSubject.registerObserver(baiduWeatherObserver);
        weatherSubject.setWeather(21l,35l,42l);

    }
}
