package session5.assigment2;

import java.util.Objects;

public class Product {
    private int id;
    private String productName;
    private int qty;

    private float price;

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

    public Product (int id, String productName, int qty, float price){
        this.id = id;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public boolean checkQuantity() {
        if (this.qty > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
