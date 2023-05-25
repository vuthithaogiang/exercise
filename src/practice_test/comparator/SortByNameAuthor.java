package practice_test.comparator;

import practice_test.Book;

import java.util.Comparator;

public class SortByNameAuthor implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {

        if(o1.getName().toString().compareTo(o2.getName().toString()) < 0){
            return -1;
        }
        if(o1.getName().toString().compareTo(o2.getName().toString())  == 0){
            return 0;
        }
        return 1;

    }
}
