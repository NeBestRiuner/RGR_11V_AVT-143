package ru.brigada.javaFX;

import ru.brigada.javaFX.Model.FIFOCache;
import ru.brigada.javaFX.Model.LRUCache;
import ru.brigada.javaFX.Model.RANDCache;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path1 = "src/main/java/ru/brigada/javaFX/text/ruslan-i-lyudmilaTest.txt";
        test(path1);
    }
    public static void test(String path) {
        File file = new File(path);
        int maxSize = 500;
        int i = 10;
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
            i+=10;
        }
        System.out.println("LRU");
        maxSize = 500;
        i = 10;
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
            i+=10;
        }
        System.out.println("RAND");
        maxSize = 500;
        i = 10;
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
            i+=10;
        }
    }

}

