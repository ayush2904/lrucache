package com.cache.storage;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class MapBasedStorage<Key,Value> implements Storage<Key, Value>{
    private HashMap<Key,Value> storage;
    private final int capacity;

    public MapBasedStorage(int capacity) {
        this.storage = new HashMap<>(capacity);
        this.capacity = capacity;
    }
    @Override
    public void add(Key key, Value value) {
        if(!isStorageFull())
           storage.put(key,value);
        else
            throw new IndexOutOfBoundsException("Storage Full ...");
    }

    @Override
    public Value get(Key key) {
       if(storage.containsKey(key)) {
           return storage.get(key);
       } else {
           throw new NoSuchElementException("element not found");
       }
    }

    @Override
    public void remove(Key key) {
        if(storage.containsKey(key)) {
           // System.out.println(storage);
             storage.remove(key);
        } else {
            throw new NoSuchElementException("element not found");
        }
    }

    @Override
    public boolean isExists(Key key) {
        return storage.containsKey(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity ? true : false;
    }
}
