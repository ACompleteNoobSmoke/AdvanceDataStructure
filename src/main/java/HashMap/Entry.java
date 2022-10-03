package HashMap;

public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V newValue){
        this.value = newValue;
    }

    public Entry<K, V> getNext(){
        return next;
    }

    public void setNext(Entry<K, V> next){
        this.next = next;
    }

    @Override
    public String toString() {
        Entry<K,V> temp = this;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.key + " -> " + temp.value + ",");
            temp = temp.next;
        }
        return sb.toString();
    }
}
