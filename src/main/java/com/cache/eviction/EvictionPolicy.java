package com.cache.eviction;

public interface EvictionPolicy<Key> {
    public void keyAccess(Key key);
    public Key evictKey();
}
