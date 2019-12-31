package mode.responsibilitychain.type1;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 9:48
 */
public class DeanApprover extends Approver {

    public DeanApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 3000 && purchaseRequest.getPrice() <= 10000)
            System.out.println(name + " 处理 " + purchaseRequest.getId()+ " : " + purchaseRequest.getTypeName());
        else
            approver.processRequest(purchaseRequest);
    }
}
