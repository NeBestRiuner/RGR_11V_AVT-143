package ru.brigada.javaFX.Model;
public class EntryC<K,V>{
    private final K k;
    private final V v;
    public K getKey() {
        return k;
    }
    public V getValue() {
        return v;
    }
    public EntryC(K k, V v){
        this.k = k;
        this.v = v;
    }
}
