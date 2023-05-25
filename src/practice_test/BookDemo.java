package practice_test;


import practice_test.comparator.SortByNameAuthor;
import practice_test.comparator.SortByPriceDECS;
import practice_test.comparator.SortByTitleASC;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookDemo {

    public static void main(String[]  args){
        int choice = 0;
        var input = new Scanner(System.in);

        var listBook = new ArrayList<Book>();

        do{
            System.out.println("=================================================");
            System.out.println("1. Add a book in list.");
            System.out.println("2. Display information all of books in the list");
            System.out.println("3. Sort book in list by title ascending");
            System.out.println("4. Sort book in list by price descending ");
            System.out.println("5. Sort book in list by the same Author");
            System.out.println("0. Exit");
            System.out.println("=================================================");
            System.out.println("Your choice? ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 0:
                    System.out.println("Thanks for using!!");
                    break;
                case 1:

                    Book book = createBook(input);
                    if(book != null){
                        listBook.add(book);
                        System.out.println("Create book complete!!");
                    }
                    else{
                        System.out.println("Create book is fail!!!");
                    }
                    break;

                case 2:
                    if(listBook.size() > 0) {
                       showListBook(listBook);
                    }
                    else{
                        System.out.println("Please create book first!!!");
                    }
                    break;
                case 3:
                    if(listBook.size() > 0) {
                        Collections.sort(listBook, new SortByTitleASC());
                       showListBook(listBook);
                    }
                    else{
                        System.out.println("Please create book first!!!");
                    }
                    break;
                case 4:
                    if(listBook.size() > 0) {
                        Collections.sort(listBook, new SortByPriceDECS());
                       showListBook(listBook);
                    }
                    else{
                        System.out.println("Please create book first!!!");
                    }
                    break;
                case 5:
                    if(listBook.size() > 0) {
                        Collections.sort(listBook, new SortByNameAuthor());
                        showListBook(listBook);
                    }
                    else{
                        System.out.println("Please create book first!!!");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
            }

        }
        while(choice != 0);
    }

    private static Book createBook(Scanner input){
        System.out.println("Enter title: ");
        var title = input.nextLine();

        System.out.println("Enter the first name of Author: ");
        var firstName = input.nextLine();

        System.out.println("Enter the last name of Author: ");
        var lastName = input.nextLine();

        var author = new Author(firstName, lastName);

        System.out.println("Enter price: ");
        var price = Double.parseDouble(input.nextLine());
        try{
            return new Book(title, author, price);
        }
        catch (InvalidPriceException e){
            e.printStackTrace();
            return null;
        }

    }

    private static void showListBook(ArrayList<Book> books) {
        System.out.printf("%-30s%-40s%-20s\n", "Title", "Name Author", "Price");
        for(var b : books){
            System.out.printf("%-30s%-40s%-20.2f\n",
                    b.getTitle(), b.getName().toString(), b.getPrice());
        }


    }


}
