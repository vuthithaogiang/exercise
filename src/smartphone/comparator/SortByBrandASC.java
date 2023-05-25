package smartphone.comparator;

import smartphone.Smartphone;

import java.util.Comparator;

public class SortByBrandASC implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2){
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
