package ru.brigada.javaFX;

import ru.brigada.javaFX.Model.FIFOCache;
import ru.brigada.javaFX.Model.LRUCache;
import ru.brigada.javaFX.Model.RANDCache;

import java.io.*;
import java.nio.charset.Charset;

public class App 
{
    public static void main( String[] args )
    {
        String path1 = "src/main/java/ru/brigada/javaFX/text/ruslan-i-lyudmilaTest.txt";
        test(path1,5000,50);
        String path2 = "src/main/java/ru/brigada/javaFX/text/Zadumavshiysya_Fizika-dlya-chaynikov-_RuLit_Me.txt";
        test(path2,5000,50);
    }
    public static void test(String path, int maxi, int di) {
        File file = new File(path);
        int maxSize =maxi;
        int i = di;
        System.out.println("Fifo");
        while (i<maxSize) {
            //создаем объект FileReader для объекта File
            FIFOCache<String,Integer> fifoCache = new FIFOCache<>(i);
            try {
                FileReader fr = new FileReader(file, Charset.defaultCharset());
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                while (line != null) {
                    // считываем остальные строки в цикле
                    String[] words = line.split("\\s*(\\s|,|!|\\.|-|;|:|\\?|\"|\\(|\\)|\\n|\\t)\\s*");
                    for (String word : words) {
                        fifoCache.put(word,0);
                    }
                    line = reader.readLine();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(fifoCache.sizeMax()+" "+fifoCache.hitPercent());
            i+=di;
        }
        System.out.println("LRU");
        maxSize = maxi;
        i = di;
        while (i<maxSize) {
            //создаем объект FileReader для объекта File
            LRUCache<String,Integer> lruCache = new LRUCache<>(i);
            try {
                FileReader fr = new FileReader(file, Charset.defaultCharset());
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                while (line != null) {
                    // считываем остальные строки в цикле
                    String[] words = line.split("\\s*(\\s|,|!|\\.|-|;|:|\\?|\"|\\(|\\)|\\n|\\t)\\s*");
                    for (String word : words) {
                        lruCache.put(word,0);
                    }
                    line = reader.readLine();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(lruCache.sizeMax()+" "+lruCache.hitPercent());
            i+=100;
        }
        System.out.println("RAND");
        maxSize = maxi;
        i = di;
        while (i<maxSize) {
            //создаем объект FileReader для объекта File
            RANDCache<String,Integer> randCache = new RANDCache<>(i);
            try {
                FileReader fr = new FileReader(file, Charset.defaultCharset());
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                while (line != null) {
                    // считываем остальные строки в цикле
                    String[] words = line.split("\\s*(\\s|,|!|\\.|-|;|:|\\?|\"|\\(|\\)|\\n|\\t)\\s*");
                    for (String word : words) {
                        randCache.put(word,0);
                    }
                    line = reader.readLine();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println(randCache.sizeMax()+" "+randCache.hitPercent());
            i+=di;
        }
    }

}

