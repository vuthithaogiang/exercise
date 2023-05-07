package session5.assigment2;

import com.sun.security.jgss.GSSUtil;

public class Test {

    public static void main(String[] args) {
        Cart cart1 = new Cart(1, "Hoa", "HN");
        Cart cart2 = new Cart(3, "An", "VP");

        Product p1 = new Product(1, "T-shirt", 2, 200);
        Product p2 = new Product(2, "Short", 2, 199);
        Product p3 = new Product(6, "Car", 1, 19999);
        System.out.println(p1);
        cart1.addProductInCart(p1);

        System.out.println(cart1);
        //thu add san pham da add
        //cart1.addProductInCart(p1);
        cart2.addProductInCart(p1);
        cart2.addProductInCart(p2);
        System.out.println(cart2);
        //cart2.removeProductInCart(p3);
        cart2.removeProductInCart(p1);
        System.out.println(cart2);

    }


}
