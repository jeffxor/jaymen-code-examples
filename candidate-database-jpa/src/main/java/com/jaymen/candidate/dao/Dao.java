package com.jaymen.candidate.dao;

import java.util.List;

import com.jaymen.candidate.dao.exceptions.DaoStoreException;

/**
 * Abstract interface to define the basic operations provided
 * by implementing concrete classes.
 *
 * @param <K> Value to find entity with
 * @param <E> Type of Entity
 */
public interface Dao<K, E> {
    E persist(E entity) throws DaoStoreException;
    void remove(E entity) throws DaoStoreException;
    E findById(K id);
    List<E> findAll();
}
