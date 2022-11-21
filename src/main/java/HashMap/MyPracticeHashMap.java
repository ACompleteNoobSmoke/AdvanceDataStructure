package HashMap;

import java.util.Arrays;
import java.util.Objects;

public class MyPracticeHashMap<K, V>{
    private final int INIT_CAP;
    private int currentSize;
    private SecondEntry[] table;

    public MyPracticeHashMap(int capacity){
        this.currentSize = 0;
        this.INIT_CAP = capacity;
        this.table = new SecondEntry[INIT_CAP];
    }

    private boolean isFull(){ return currentSize == table.length; }

    private boolean isNull(Object... obj){ return Arrays.stream(obj).anyMatch(Objects::isNull); }

    public void put(K key, V value){
        if(isNull(key, value)) throw new IllegalArgumentException("Key Or Value Is Null");
        if(isFull()) resize(table.length);
        int hashIndex = key.hashCode() % table.length;
        if(hashIndex < 0) return;
        SecondEntry<K, V> currentEntry = table[hashIndex];

        if(isNull(currentEntry)) table[hashIndex] = new SecondEntry<>(key, value);
        else{
            while(!isNull(currentEntry.getNextEntry())){
                if(currentEntry.getKey().equals(key)){ currentEntry.setValue(value); return; }
                currentEntry = currentEntry.getNextEntry();
            }
            if(currentEntry.getKey().equals(key)) { currentEntry.setValue(value); return; }
            currentEntry.setNextEntry(new SecondEntry<>(key, value));
        }
        currentSize++;
    }

    public V getValue(K key){
        if(isNull(key)) throw new IllegalArgumentException("Key is Null");
        int hashIndex = key.hashCode() % table.length;
        SecondEntry<K, V> searchEntry = table[hashIndex];
        if(isNull(searchEntry)) return null;

        while(!isNull(searchEntry)){
            if(searchEntry.getKey().equals(key)) return searchEntry.getValue();
            searchEntry = searchEntry.getNextEntry();
        }

        return null;
    }

    public SecondEntry<K, V> remove(K key){
        if(isNull(key)) throw new IllegalArgumentException("Key Is Null");
        int hashIndex = key.hashCode() % table.length;
        SecondEntry<K, V> removeEntry = table[hashIndex];
        if(isNull(removeEntry)) return null;

        if(removeEntry.getKey().equals(key)){
            table[hashIndex] = removeEntry.getNextEntry();
            removeEntry.setNextEntry(null);
            currentSize--;
            return removeEntry;
        }

        SecondEntry<K, V> previousEntry = removeEntry;
        removeEntry = removeEntry.getNextEntry();

        while(!isNull(removeEntry)){
            if(removeEntry.getKey().equals(key)){
                previousEntry.setNextEntry(removeEntry.getNextEntry());
                removeEntry.setNextEntry(null);
                currentSize--;
                return removeEntry;
            }

            previousEntry = removeEntry;
            removeEntry = removeEntry.getNextEntry();
        }
        return null;
    }

    private void resize(int length){
        if(length <= 0) return;
        int newLength = 2 * length + 1;
        SecondEntry<K, V>[] tempTable = table;
        table = new SecondEntry[newLength];
        currentSize = 0;

        for(SecondEntry<K, V> entry: tempTable){
            while (!isNull(entry)) {
                put(entry.getKey(), entry.getValue());
                entry = entry.getNextEntry();
            }
        }
    }

    public SecondEntry<K, V>[] getTable(){ return table; }
}