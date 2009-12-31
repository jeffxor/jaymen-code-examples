package com.jaymen.candidate.dao;

import java.util.Collection;

public interface Dao<K, E> {
    void persist(E entity);
    void remove(E entity);
    E findById(K id);
    Collection<E> findAll();
}
