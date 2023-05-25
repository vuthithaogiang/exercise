package practice_test.comparator;

import practice_test.Book;
import smartphone.Smartphone;

import java.util.Comparator;

public class SortByPriceDECS implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o2.getPrice() < o1.getPrice()) {
            return -1;
        }
        if (o1.getPrice() == o2.getPrice()) {
            return 0;
        }
        return 1;
    }
}
