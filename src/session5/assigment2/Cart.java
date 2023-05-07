package session5.assigment2;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Objects;

public class Cart {
    private int id;
    private String nameCustomer;
    private float grandTotal;
    private ArrayList<Product> listProduct = new ArrayList<>();
    private String city;

    public Cart() {

    }

    public Cart(int id) {
        this.id = id;
    }

    public Cart(int id, String nameCustomer, String city) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public float getGrandTotal() {
        return  this.grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addProductInCart(Product p) {
        if (!this.listProduct.contains(p)) {
            this.listProduct.add(0, p);
        } else {
            System.out.println("Can not add product have already in cart!!!");
        }
         this.setGrandTotal(this.calculateGrandTotal());
    }
    public void removeProductInCart(Product p) {
        if(this.listProduct.contains(p)) {
            this.listProduct.remove(p);
        }
        else{
            System.out.println("Can not remove product have already in cart!!!");
        }
        this.setGrandTotal(this.calculateGrandTotal());
    }
    public float calculateGrandTotal() {
        float total = 0;
        for (var item : this.listProduct) {
            total += item.getPrice();
        }

        if (this.city == "HN" || this.city == "HCM") {
            total -= total * 0.1;
        }
        else{
            total -= total * 0.2;

        }
        System.out.println(total);

        return total;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", city=" + city +
                ", grandTotal=" + grandTotal +
                '}';
    }

}
