package com.ibm.tarjetas.apirest.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAOImpl <E, R extends CrudRepository<E, Integer>> implements GenericDAO<E>
{

	protected final R repository;
	
	public GenericDAOImpl(R repository)
	{
		this.repository = repository;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Integer id) 
	{
		return repository.findById(id);
	}

	@Override
	public E save(E entity)
	{
		return repository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() 
	{
		return repository.findAll();
	}

	@Override
	public void deleteById(Integer id) 
	{
		repository.deleteById(id);
	}


}
