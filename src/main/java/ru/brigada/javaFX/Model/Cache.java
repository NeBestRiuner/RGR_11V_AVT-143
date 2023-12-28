package ru.brigada.javaFX.Model;

public interface Cache <K,V>{
    void put(K key, V value);
    V getV(K key);
    int size();
    boolean isEmpty();
    void clear();
    int sizeMax();
}
