package HashMap;

public class MyPracticeHashMap<K, V>{
    private SecondEntry<K, V>[] table;
    private final int INIT_CAP;
    private int currentSize;

    public MyPracticeHashMap(int capacity){
        this.currentSize = 0;
        this.INIT_CAP = capacity;
        this.table = new SecondEntry[capacity];
    }

    private boolean isFull(){ return currentSize == table.length; }

    private boolean isNull(Object obj){ return obj == null; }

    public void put(K key, V value){
        if(isNull(key) || isNull(value)) return;
        if(isFull()) resize(table.length);
        int hashCode = key.hashCode() % table.length;
        SecondEntry<K, V> current = table[hashCode];
        if(isNull(current)) return;

        if(isNull(current)) table[hashCode] = new SecondEntry<>(key, value);
        else{
            while(!isNull(current.getNextEntry())){
                if(current.getKey().equals(key)){ current.setValue(value); return; }
                current = current.getNextEntry();
            }
            if(current.getKey().equals(key)){ current.setValue(value); return; }
            current.setNextEntry(new SecondEntry<>(key, value));
        }
        currentSize++;
    }

    public V getValue(K key){
        if(isNull(key)) return null;
        int hashCode = key.hashCode() % table.length;
        SecondEntry<K, V> currentEntry = table[hashCode];
        if(isNull(currentEntry)) return null;

        while(!isNull(currentEntry)){
            if(currentEntry.getKey().equals(key)) return currentEntry.getValue();
            currentEntry = currentEntry.getNextEntry();
        }
        return null;
    }

    public SecondEntry<K, V> remove(K key){
        if(isNull(key)) return null;
        int hashCode = key.hashCode() % table.length;
        SecondEntry<K, V> currentEntry = table[hashCode];
        if(isNull(currentEntry)) return null;

        if(currentEntry.getKey().equals(key)){
            table[hashCode] = currentEntry.getNextEntry();
            currentEntry.setNextEntry(null);
            currentSize--;
            return currentEntry;
        }

        SecondEntry<K, V> previousEntry = currentEntry;
        currentEntry = currentEntry.getNextEntry();

        while(!isNull(currentEntry)){
            if(currentEntry.getKey().equals(key)){
                previousEntry.setNextEntry(currentEntry.getNextEntry());
                currentEntry.setNextEntry(null);
                currentSize--;
                return currentEntry;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
        return null;
    }

    private void resize(int length){
        int newLength = 2 * length + 1;
        SecondEntry<K, V> tempTable[] = table;
        table = new SecondEntry[newLength];
        currentSize = 0;

        for(int i = 0; i < length; i++){
            SecondEntry<K, V> currentEntry = tempTable[i];
            if(!isNull(currentEntry)){
                while(!isNull(currentEntry)){
                    put(currentEntry.getKey(), currentEntry.getValue());
                    currentEntry = currentEntry.getNextEntry();
                }
            }
        }
    }
}