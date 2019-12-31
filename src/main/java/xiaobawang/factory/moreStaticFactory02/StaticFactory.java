package xiaobawang.factory.moreStaticFactory02;

import xiaobawang.factory.MailSender;
import xiaobawang.factory.SMSSender;
import xiaobawang.factory.Sender;

/**
 * @Author: DuanTong
 * @Date: 2019/7/28 10:49
 */
public class StaticFactory {

    public static Sender productSMS(){
        return new SMSSender();
    }

    public static Sender productMail(){
        return new MailSender();
    }

}
