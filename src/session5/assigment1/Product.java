package session5.assigment1;

public class Product {
    private int id;
    private String productName;
    private int qty;

    public Product() {

    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String productName){
        this.id = id;
        this.productName = productName;
    }

    public Product (int id, String productName, int qty){
        this.id = id;
        this.productName = productName;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean checkQuantity(){
        if(this.qty > 0) {
            return true;
        }
        else{
            return false;
        }
    }

}
