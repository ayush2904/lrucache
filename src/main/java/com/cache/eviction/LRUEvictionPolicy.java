package com.cache.eviction;

import com.cache.util.dll.DLL;
import com.cache.util.dll.DLLNODE;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DLL<Key> dll = new DLL();
    Map<Key, DLLNODE<Key>> mapping = new HashMap<>();
    @Override
    public void keyAccess(Key key) {
     if(mapping.containsKey(key)) {
        // System.out.println("key found in mappings");
         dll.detachNode(mapping.get(key));
         DLLNODE newNode = dll.addNodeToLast(key);
         mapping.put(key,newNode);
     } else {
         DLLNODE newNode = dll.addNodeToLast(key);
         mapping.put(key,newNode);
         //System.out.println("key not found in mappings");
      //   System.out.println(mapping);
     }
    }

    @Override
    public Key evictKey() {
        DLLNODE<Key> first = dll.getFirst();
        if(first!=null) {
            dll.detachNode(first);
            mapping.remove(first.getElement());
            return first.getElement();
        }
        return null;
    }
}
