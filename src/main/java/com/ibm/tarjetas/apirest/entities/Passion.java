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
@Table (name = "passions", schema = "bank")
public class Passion implements Serializable
{
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, length = 60)
	private String nombre;
	
	//RELACIONES
	//@OneToOne no necesaria por el optional = true en Client
	
	//CONSTRUCTOR
	public Passion(Integer id, String nombre)
	{
		this.id = id;
		this.nombre = nombre;
	}
	

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
		Passion other = (Passion) obj;
		return Objects.equals(id, other.id);
	}


	private static final long serialVersionUID = -5067706297384550148L;
}
