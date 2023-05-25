package smartphone.comparator;

import smartphone.Smartphone;

import java.util.Comparator;

public class SortByPriceDESC implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        if (o2.getPrice() < o1.getPrice()) {
            return -1;
        }
        if (o2.getPrice() == o1.getPrice()) {
            return 0;
        }
        return 1;
    }
}
