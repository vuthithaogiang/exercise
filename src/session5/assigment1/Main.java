package session5.assigment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        var input = new Scanner(System.in);
       var product = createNewProduct(input);
        System.out.println(product.getProductName());
        System.out.printf("%-12s%-25s%-15s\n",
                "ID", "Name", "Qty");

        showProductInfo(product);
        boolean checkQty = product.checkQuantity();

        if(checkQty == true){
            System.out.println("Product still available!");
        }
        else{
            System.out.println("Product already sold out!!!");
        }

    }

    private static Product createNewProduct(Scanner input){
        System.out.println("Enter id: ");
        var id = input.nextInt();
        input.nextLine();
        System.out.println("Enter name product: ");
        var name = input.nextLine();
        System.out.println("Enter qty: ");
        var qty = input.nextInt();
        Product p = new Product(id, name, qty);
        return p;
    }

    private static void showProductInfo(Product p ){
        System.out.printf("%-12d%-25s%-15d\n",
                p.getId(), p.getProductName(), p.getQty());
    }
}
