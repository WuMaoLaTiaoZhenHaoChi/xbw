package xiaobawang.unit;

import org.junit.Test;
import xiaobawang.factory.Sender;
import xiaobawang.factory.moreFactory01.SendFactory02;

public class SendFactory02Test {

    @Test
    public void produce() {

        SendFactory02 sendFactory02 = new SendFactory02();
        Sender sender = sendFactory02.productSMS();
        sender.send();

    }

}
