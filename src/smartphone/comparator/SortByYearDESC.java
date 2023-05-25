package smartphone.comparator;

import smartphone.Smartphone;

import java.util.Comparator;

public class SortByYearDESC implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o2.getYear() - o1.getYear();
    }
}
