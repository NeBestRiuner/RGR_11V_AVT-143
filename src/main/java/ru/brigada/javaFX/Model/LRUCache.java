package ru.brigada.javaFX.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache <K,V> extends MainCache<K,V> {

    public LRUCache(int sizeMax){
        super(sizeMax);
    }
    @Override
    public void put(K key, V value) {
        EntryC<K, V> item = new EntryCLRU<>(key, value);
        if (hashMap.containsKey(item.getKey())) {
            for(EntryC it :linkedList){
                if(it.getKey().equals(item.getKey())){
                    EntryCLRU entryCLRU = (EntryCLRU)it;
                    entryCLRU.increaseUsedNum();
                    break;
                }
            }
            gotNum++;
        } else {
            if (curSize < sizeMax) {
                linkedList.add(item);
                hashMap.put(key, value);
                curSize++;
            }else{
                replace();
                linkedList.add(item);
                hashMap.put(key, value);
            }
            addNum++;
        }
    }
    @Override
    public void replace() {
        EntryCLRU maxEntry = (EntryCLRU) this.linkedList.getFirst();
        for(EntryC it :linkedList){
            if(maxEntry.getUsedNum()>((EntryCLRU)it).getUsedNum()){
                maxEntry =(EntryCLRU)it;
            }
        }
        this.linkedList.remove(maxEntry);
        this.hashMap.remove(maxEntry.getKey());
    }
}