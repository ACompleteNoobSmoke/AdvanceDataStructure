package HashMap;

import java.util.Arrays;
import java.util.Objects;

public class MyPracticeHashMap<K, V>{
    private int size;
    private int capacity;
    private SecondEntry<K, V>[] table;

    public MyPracticeHashMap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.table = new SecondEntry[capacity];
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == table.length; }
    private boolean isNull(Object... objs){ return Arrays.stream(objs).anyMatch(Objects::isNull); }

    private void resize(int length){
        int newLength = 2 * length + 1;
        SecondEntry<K, V>[] oldTable = table;
        table = new SecondEntry[newLength];
        size = 0;

        for(SecondEntry<K, V> entry: oldTable){
            while(!isNull(entry)){
                put(entry.getKey(), entry.getValue());
                entry = entry.getNextEntry();
            }
        }
    }

    public void put(K key, V value){
        if(isNull(key, value)) throw new IllegalArgumentException("Key or Value Is Null");
        if(isFull()) resize(table.length);
        int hashIndex = key.hashCode() % table.length;
        if(hashIndex < 0) return;
        SecondEntry<K, V> entry = table[hashIndex];

        if(isNull(entry)) table[hashIndex] = new SecondEntry<>(key, value);
        else{
            while(!isNull(entry.getNextEntry())){
                if(entry.getKey().equals(key)) { entry.setValue(value); return; }
                entry = entry.getNextEntry();
            }
            if(entry.getKey().equals(key)){ entry.setValue(value); return; }
            entry.setNextEntry(new SecondEntry<>(key, value));
        }
        size++;
    }

    public V getValue(K key){
        if(isNull(key)) throw new IllegalArgumentException("Key Is Null");
        int hashIndex = key.hashCode() % table.length;
        if(isEmpty() || hashIndex < 0) return null;
        SecondEntry<K, V> searchEntry = table[hashIndex];

        while(!isNull(searchEntry)){
            if(searchEntry.getKey().equals(key)) return searchEntry.getValue();
            searchEntry = searchEntry.getNextEntry();
        }

        return null;
    }

    public SecondEntry<K, V> remove(K key){
        if(isNull(key)) throw new IllegalArgumentException("Key Is Null");
        int hashIndex = key.hashCode() % table.length;
        if(isEmpty() || hashIndex < 0) return null;
        SecondEntry<K, V> removeEntry = table[hashIndex];
        if(isNull(removeEntry)) return null;

        if(removeEntry.getKey().equals(key)){
            table[hashIndex] = removeEntry.getNextEntry();
            removeEntry.setNextEntry(null);
            size--;
            return removeEntry;
        }

        SecondEntry<K, V> previousEntry = removeEntry;
        removeEntry = removeEntry.getNextEntry();

        while(!isNull(removeEntry)){
            if(removeEntry.getKey().equals(key)){
                previousEntry.setNextEntry(removeEntry.getNextEntry());
                removeEntry.setNextEntry(null);
                size--;
                return removeEntry;
            }
            previousEntry = removeEntry;
            removeEntry = previousEntry.getNextEntry();
        }

        return null;
    }

    public SecondEntry<K, V>[] getTable(){ return table; }
}