package smartphone.comparator;

import smartphone.Smartphone;

import java.util.Comparator;

public class SortByBrandDESC implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2){
        return o2.getBrand().compareTo(o1.getBrand());
    }
}
