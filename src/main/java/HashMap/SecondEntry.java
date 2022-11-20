package HashMap;

public class SecondEntry<K, V>{
    private K key;
    private V value;
    private SecondEntry<K, V> nextEntry;

    public SecondEntry(K key, V value){
        this(key, value, null);
    }

    public SecondEntry(K key, V value, SecondEntry<K, V> nextEntry){
        this.key = key;
        this.value = value;
        this.nextEntry = nextEntry;
    }

    public K getKey(){ return key; }

    public V getValue(){ return value; }

    public void setValue(V value) { this.value = value; }

    public SecondEntry<K, V> getNextEntry(){ return nextEntry; }

    public void setNextEntry(SecondEntry<K, V> nextEntry){ this.nextEntry = nextEntry; }
}