package ru.brigada.javaFX.Model;
import java.util.Random;
public class RANDCache<K,V> extends MainCache<K,V> {
    public RANDCache(int sizeMax){
        super(sizeMax);
    }
    @Override
    public void replace() {
        Random rnd = new Random();
        EntryC entryC = this.linkedList.get(rnd.nextInt(super.sizeMax()));
        this.linkedList.remove(entryC);
        this.hashMap.remove(entryC.getKey());
    }
}
