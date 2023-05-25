package smartphone.comparator;

import smartphone.Smartphone;

import java.util.Comparator;

public class SortByYearASC implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getYear() - o2.getYear();
    }
}
