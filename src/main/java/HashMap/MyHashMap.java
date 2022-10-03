package HashMap;

public class MyHashMap<K, V> {
    private final int INITIAL_CAPACITY = 8;
    private int currentSize;
    private Entry<K, V> table[];

    public MyHashMap(){
        this.table = new Entry[INITIAL_CAPACITY];
        this.currentSize = 0;
    }

    private boolean isNull(Object object) {return object == null;}

    private void put(K key, V value){
        if(isNull(key) || isNull(value)) return;
        int hashIndex = key.hashCode() % table.length;
        Entry<K, V> existingEntry = table[hashIndex];

        if(existingEntry == null) table[hashIndex] = new Entry<>(key, value);
        else{
            while(existingEntry.getNext() != null){
                if(existingEntry.getKey() == key) { existingEntry.setValue(value); return; }
                existingEntry = existingEntry.getNext();
            }
            if(existingEntry.getKey() == key) { existingEntry.setValue(value); return; }
            existingEntry.setNext(new Entry<>(key, value));
        }
        currentSize++;
    }

    private V getValue(K key){
        if(isNull(key)) return null;
        int hashIndex = key.hashCode() % table.length;
        Entry<K, V> existingEntry = table[hashIndex];

        if(isNull(existingEntry)) return null;
        while(!isNull(existingEntry)){
            if(existingEntry.getKey() == key) return existingEntry.getValue();
            existingEntry = existingEntry.getNext();
        }
        return null;
    }

    private Entry<K, V> remove(K key){
        if (isNull(key)) return null;
        int hashIndex = key.hashCode() % table.length;
        Entry<K, V> removeEntry = table[hashIndex];

        if(isNull(removeEntry)) return null;
        else if(removeEntry.getKey() == key){
            table[hashIndex] = removeEntry.getNext();
            removeEntry.setNext(null);
            currentSize--;
            return removeEntry;
        }

        Entry<K, V> previousEntry = removeEntry;
        removeEntry = removeEntry.getNext();
        while(!isNull(removeEntry)){
            if(removeEntry.getKey() == key){
                previousEntry.setNext(removeEntry.getNext());
                removeEntry.setNext(null);
                currentSize--;
                return removeEntry;
            }
            previousEntry = removeEntry;
            removeEntry = removeEntry.getNext();
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }


}
