package com.ibm.tarjetas.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.tarjetas.apirest.entities.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer>
{
	//QUERYS
}
