package mode.responsibilitychain.type1;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 9:36
 *
 * 职责链模式
 */
public abstract class Approver {
    public Approver approver;
    public String name;

    public Approver(String name) {
        this.name = name;
    }

    //设置下一级别的处理者
    public void setNextApprover(Approver approver){
        this.approver = approver;
    }

    //处理事情
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}
