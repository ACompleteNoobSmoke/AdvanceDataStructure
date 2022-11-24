package HashMap;

import java.util.Arrays;
import java.util.Objects;

public class MyPracticeHashMap<K, V>{
    private int size;
    private SecondEntry<K,V>[] table;

    public MyPracticeHashMap(int capacity) {
        this.size = 0;
        this.table = new SecondEntry[capacity];
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == table.length; }
    private boolean isNull(Object... objects){ return Arrays.stream(objects).anyMatch(Objects::isNull); }
    private boolean isKeyEquals(K objectKey, K newKey) { return objectKey.equals(newKey); }

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
        if(isNull(key, value)) throw new IllegalArgumentException("Key or Data Is Null");
        if(isFull()) resize(table.length);
        int hashIndex = key.hashCode() % table.length;
        if(hashIndex < 0) return;
        SecondEntry<K, V> current = table[hashIndex];

        if(isNull(current)) table[hashIndex] = new SecondEntry<>(key, value);
        else{
            while(!isNull(current.getNextEntry())){
                if(isKeyEquals(current.getKey(), key)) { current.setValue(value); return; }
                current = current.getNextEntry();
            }
            if(isKeyEquals(current.getKey(), key)) { current.setValue(value); return; }
            current.setNextEntry(new SecondEntry<>(key, value));
        }
        size++;
    }

    public V getValue(K key){
        if(isNull(key)) throw new IllegalArgumentException("Key Is Null");
        int hashIndex = key.hashCode() % table.length;
        if(isEmpty() || hashIndex < 0) return null;
        SecondEntry<K, V> searchEntry = table[hashIndex];

        while(!isNull(searchEntry)){
            if(isKeyEquals(searchEntry.getKey(), key)) return searchEntry.getValue();
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

        if(isKeyEquals(removeEntry.getKey(), key)){
            table[hashIndex] = removeEntry.getNextEntry();
            removeEntry.setNextEntry(null);
            size--;
            return removeEntry;
        }

        SecondEntry<K, V> previousEntry = removeEntry;
        removeEntry = removeEntry.getNextEntry();

        while(!isNull(removeEntry)){
            if(isKeyEquals(removeEntry.getKey(), key)){
                previousEntry.setNextEntry(removeEntry.getNextEntry());
                removeEntry.setNextEntry(null);
                size--;
                return removeEntry;
            }
            previousEntry = removeEntry;
            removeEntry = removeEntry.getNextEntry();
        }
        return null;
    }

    public SecondEntry<K, V>[] getTable(){ return table; }
}