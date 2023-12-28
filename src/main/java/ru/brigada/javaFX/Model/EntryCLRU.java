package ru.brigada.javaFX.Model;

public class EntryCLRU<K,V> extends EntryC<K,V>{
    private int usedNum;
    EntryCLRU(K k, V v){
        super(k,v);
        usedNum = 0;
    }
    public int getUsedNum(){
        return usedNum;
    }
    public void setUsedNum(int usedNum){
        this.usedNum = usedNum;
    }
    public void increaseUsedNum(){
        usedNum++;
    }
}

