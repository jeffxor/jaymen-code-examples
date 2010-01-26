package com.jaymen.candidate.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.candidate.dao.Dao;
import com.jaymen.candidate.dao.exceptions.DaoStoreException;

/**
 * Implementation of the Dao interface using generics. This allows for 
 * simple implementation as well as abstraction of basic database handling
 * code.
 *
 * @param <K> Value to find entity with
 * @param <E> Type of Entity
 */
public abstract class AbstractDao<K, E> implements Dao<K, E> {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractDao.class);
	
	protected Class<E> entityClass;
 
	@PersistenceContext
	protected EntityManager entityManager;
 
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}
 
	public E persist(E entity) throws DaoStoreException { 
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {			
			entityManager.getTransaction().rollback();
			throw new DaoStoreException(e);
		}
		return entity;
	}
 
	public void remove(E entity) throws DaoStoreException { 
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {			
			entityManager.getTransaction().rollback();
			throw new DaoStoreException(e);
		} 
	}	
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() { 
		Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e");
		log.debug("Attempting to find all: entitity: " + entityClass.getName() + " query: " + q.toString());
		return q.getResultList();
	}
 
	public E findById(K id) { return entityManager.find(entityClass, id); }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
