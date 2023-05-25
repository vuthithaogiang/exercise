package practice_test.comparator;

import practice_test.Book;
import smartphone.Smartphone;

import java.util.Comparator;

public class SortByTitleASC implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
    }
}
