package com.cache;

import com.cache.eviction.EvictionPolicy;
import com.cache.storage.Storage;

public class Cache<Key,Value> {
    private Storage<Key,Value> storage;
    private EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage storage, EvictionPolicy evictionPolicy) {
        this.storage=storage;
        this.evictionPolicy=evictionPolicy;
    }

    public boolean put(Key key, Value value) {
        try {
            this.storage.add(key, value);
        } catch (IndexOutOfBoundsException e) {
            Key keyToBeEvicted = this.evictionPolicy.evictKey();
            System.out.println("Key to be evicted : "+ keyToBeEvicted);
            this.storage.remove(keyToBeEvicted);
            put(key,value);
        }
        this.evictionPolicy.keyAccess(key);
        return false;
    }

    public Value get(Key key) {
        if(storage.isExists(key)) {
            this.evictionPolicy.keyAccess(key);
            return this.storage.get(key);
        }
        return null;
    }
}
