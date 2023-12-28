package ru.brigada.javaFX.Model;

import java.util.Map;

public class EntryC<K,V>{
    K k;
    V v;
    public Object getKey() {
        return k;
    }
    public Object getValue() {
        return v;
    }
    public EntryC(K k, V v){
        this.k = k;
        this.v = v;
    }
}
