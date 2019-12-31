package xiaobawang.factory.moreFactory01;

import xiaobawang.factory.MailSender;
import xiaobawang.factory.SMSSender;
import xiaobawang.factory.Sender;

public class SendFactory02 {

    public Sender productSMS(){
        return new SMSSender();
    }

    public Sender productMail(){
        return new MailSender();
    }

}
