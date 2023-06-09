package com.cache;

import com.cache.eviction.LRUEvictionPolicy;
import com.cache.storage.MapBasedStorage;
import com.cache.util.dll.DLL;
import com.cache.util.dll.DLLNODE;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
      /*  DLL dll = new DLL();
        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
            dll.addNodeToFront(i);
            System.out.println("first is "+dll.getFirst().getElement()+" : "+" last is "+dll.getTail().getElement());
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i+5);
            dll.addNodeToLast(i+5);
            System.out.println("first is "+dll.getFirst().getElement()+" : "+" last is "+dll.getTail().getElement());
        }

        DLLNODE head=dll.getFirst();
        while(head !=null)
        {
            System.out.println(head.getElement());
            head = head.getNext();
        }

        DLLNODE tail=dll.getTail();
        while(tail !=null)
        {
            System.out.println(tail.getElement());
            tail = tail.getPrev();
        }
        */
        Cache cache = new Cache(new MapBasedStorage(2),new LRUEvictionPolicy());

       /* for (int i = 1; i <= 10; i++) {
            System.out.println(" ------------i = " + i+" -------------------------");
            System.out.println("get called for "+(i-3)+" "+cache.get(i-3));
            cache.put(i,i);
        }*/

        System.out.println("Testing ... ");
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,"Aush");


    }
}