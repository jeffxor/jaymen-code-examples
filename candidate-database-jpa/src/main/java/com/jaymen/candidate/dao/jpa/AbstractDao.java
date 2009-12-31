package com.jaymen.candidate.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaymen.candidate.dao.Dao;


public abstract class AbstractDao<K, E> implements Dao<K, E> {
	
	private Logger log = LoggerFactory.getLogger(AbstractDao.class);
	
	protected Class<E> entityClass;
 
	@PersistenceContext
	protected EntityManager entityManager;
 
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}
 
	public void persist(E entity) { entityManager.persist(entity); }
 
	public void remove(E entity) { entityManager.remove(entity); }
	
	
	@SuppressWarnings("unchecked")
	public Collection<E> findAll() { 
		Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e");
		log.debug("Attempting to find all: " + "entitity: " + entityClass.getName() + " query: " + q.toString());
		return q.getResultList();
	}
 
	public E findById(K id) { return entityManager.find(entityClass, id); }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
