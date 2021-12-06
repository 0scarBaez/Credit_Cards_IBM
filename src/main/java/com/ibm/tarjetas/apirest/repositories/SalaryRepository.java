package com.ibm.tarjetas.apirest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.tarjetas.apirest.entities.Salary;


@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer>
{

}
