package Sort;

public interface SortingMethods <T extends Comparable<T>>{
    void insert(T newData);
    void swap(int firstIndex, int secondIndex);
    void sort();
}
