package com.ibm.tarjetas.apirest.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "salaries", schema = "bank")
public class Salary implements Serializable

{
	//PARÁMETROS

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="salaries")
	private Integer salary;
	
	//CONSTRUCTOR
	
	public Salary(Integer id, Integer salary) {
		super();
		this.id = id;
		this.salary = salary;
	}
	
	//HASHCODE
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		return Objects.equals(id, other.id);
	}
	
	private static final long serialVersionUID = -851495614969985939L;

}
