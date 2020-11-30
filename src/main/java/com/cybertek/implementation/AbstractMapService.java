package com.cybertek.implementation;

import java.util.*;

public abstract class AbstractMapService<ID, T> {

    protected Map<ID, T> map = new HashMap<>();

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    T findById (ID id) {
        return map.get(id);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T obj) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    void update(ID id, T obj) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
        map.put(id, obj);
    }
}
