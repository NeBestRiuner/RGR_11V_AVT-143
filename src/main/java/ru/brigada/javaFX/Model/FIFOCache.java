package ru.brigada.javaFX.Model;
public class FIFOCache<K,V> extends MainCache<K,V>{
    public FIFOCache(int sizeMax){
        super(sizeMax);
    }
    @Override
    public void replace() {
        this.hashMap.remove(linkedList.getFirst().getKey());
        this.linkedList.removeFirst();
    }
}
