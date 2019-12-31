package xiaobawang.factory.easyFactory;

import xiaobawang.factory.MailSender;
import xiaobawang.factory.SMSSender;
import xiaobawang.factory.Sender;

public class SendFactory01 {

    public Sender produce(String type){
        if(type.equals("mail"))
            return new MailSender();
        if(type.equals("sms"))
            return new SMSSender();
        return null;
    }

}
