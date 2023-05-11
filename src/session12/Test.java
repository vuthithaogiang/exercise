package session12;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        var choice = 0;
        var input = new Scanner(System.in);
        ArrayList<News> listNews = new ArrayList<>();


        do{
            System.out.println("=======================");
            System.out.println("1. Add a news");
            System.out.println("2. Add rating for a news by ID");
            System.out.println("3. Display news");
            System.out.println("0. Exit");
            System.out.println("==========================");

            System.out.println("Enter your choice? ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 0 :
                    System.out.println("Thanks!!!!");
                    break;
                case 1:
                    News n = getInfoNews(input);
                    if(n!= null) {
                        listNews.add(n);
                        System.out.println("Add news complete!!");
                    }
                    break;
                case 2:
                    System.out.println("Enter ID's news that you want to add rating: ");
                    var idNews = input.nextInt();

                    int indexOfNews = findNewsById(listNews, idNews);

                    if(indexOfNews == -1){
                        System.out.println("Don't find news has id = " + idNews);

                    }
                    else{
                        listNews.get(indexOfNews).InputRate();
                    }

                    break;
                case 3:
                    showInfoListNews(listNews);
                    break;

                default:
                    System.out.println("Invalid choice!!!!");
                    break;
            }
        }
        while(choice!= 0);

    }

    private static News getInfoNews(Scanner input) {
        System.out.println("Enter id: ");
        var id = input.nextInt();
        input.nextLine();
        System.out.println("Enter title: ");
        var title = input.nextLine();
        System.out.println("Enter publish date: ");
        var publishDate = input.nextLine();
        System.out.println("enter author: ");
        var author = input.nextLine();
        System.out.println("Enter content: ");
        var content = input.nextLine();


        News n = new News(id, title, publishDate, author, content);
        return n;
    }

    private static int findNewsById(ArrayList<News> list, int id){
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return  -1;
    }

    private static void showInfoListNews(ArrayList<News> list) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID", "Title", "Publish Date" , "Author", "Content", "Average Rate");
        for(var item : list) {
            item.Display();
        }
    }
}
