package com.jaymen.candidate.mvc.service;

import java.util.List;

public interface AbstractService<K, E> {
	
	public E get(K id);
	public List<E> getAll();
	public Boolean delete(K id);

}
