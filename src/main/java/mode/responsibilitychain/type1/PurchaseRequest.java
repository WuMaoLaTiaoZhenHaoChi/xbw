package mode.responsibilitychain.type1;

/**
 * @Author: 小霸王
 * @Date: 2019/11/7 9:21
 */
public class PurchaseRequest {
    private String typeName;
    private int price;
    private int id;

    public PurchaseRequest(String typeName, int price) {
        this.typeName = typeName;
        this.price = price;
        this.id = (int) (Math.random() * 100);
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
