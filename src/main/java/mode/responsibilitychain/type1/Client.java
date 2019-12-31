package mode.responsibilitychain.type1;

import org.junit.Test;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 9:52
 */
public class Client {

    @Test
    public void test(){
        PurchaseRequest purchaseRequest = new PurchaseRequest(" type1 ", 30001);

        DirectorApprover directorApprover = new DirectorApprover("系主任");
        DeanApprover deanApprover = new DeanApprover("院长");
        VicePresidentApprover vicePresidentApprover = new VicePresidentApprover("副院长");
        PresidentApprover presidentApprover = new PresidentApprover("校长");

        directorApprover.setNextApprover(deanApprover);
        deanApprover.setNextApprover(vicePresidentApprover);
        vicePresidentApprover.setNextApprover(presidentApprover);
        presidentApprover.setNextApprover(directorApprover);

        deanApprover.processRequest(purchaseRequest);

    }

}
