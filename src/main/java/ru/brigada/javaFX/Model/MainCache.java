package ru.brigada.javaFX.Model;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class MainCache<K,V> implements Cache<K,V>{
    int sizeMax;
    int curSize = 0;
    HashMap<K, V> hashMap;
    LinkedList<EntryC<K, V>> linkedList;
    int addNum = 0;
    int gotNum = 0;

    public MainCache(int sizeMax) {
        if(sizeMax>0){
        this.sizeMax = sizeMax;
        this.hashMap = new HashMap<>();
        this.linkedList = new LinkedList<>();
        }
    }
    @Override
    public void put(K key, V value) {
        EntryC<K, V> item = new EntryC<>(key, value);
        if (hashMap.containsKey(item.getKey())) {
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
    public void replace() {}
    public void setAddNum(int num){
        this.addNum = num;
    }

    public void setGotNum(int gotNum) {
        this.gotNum = gotNum;
    }
    @Override
    public V getV(K key){
        return this.hashMap.get(key);
    }
    @Override
    public  boolean isEmpty(){
        if(curSize==0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void clear(){
        this.linkedList.clear();
        this.hashMap.clear();
    }
    @Override
    public int size(){
        return this.curSize;
    }
    @Override
    public int sizeMax(){
        return sizeMax;
    }
    public double hitPercent(){
        return (double)gotNum/(double)addNum;
    }
}
