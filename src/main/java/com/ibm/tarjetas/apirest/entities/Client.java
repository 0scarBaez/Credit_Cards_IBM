package com.ibm.tarjetas.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "clients", schema = "bank")
public class Client implements Serializable
{
	//ATRIBUTOS
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "age")
	private Integer edad;
	
	@Column(name= "name", nullable = false, length = 60)
	private String name;
	
	@Column(name= "last_name", nullable = false, length = 60)
	private String lastName;
	

	@Column(name= "createDate")
	private Date createDate;
	
	@Column(name= "updateDate")
	private Date updateDate;
	
	
	//RELACIONES
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "passion_id", foreignKey = @ForeignKey(name = "FK_PASSION_ID") )
	private Passion passion;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "salary_id", foreignKey = @ForeignKey(name = "FK_SALARY_ID") )
	private Salary salary;
	
	@ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
	private Set<Card> cards;
	
	
	//CONSTRUCTOR

	public Client(Integer id, Integer edad, String name, String lastName, Passion passion, Salary salary,
			Set<Card> cards) {
		super();
		this.id = id;
		this.edad = edad;
		this.name = name;
		this.lastName = lastName;
		this.passion = passion;
		this.salary = salary;
		this.cards = cards;
	}

	//HASH CODE
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	//FECHAS CREACION Y EDICION
	
	@PrePersist
	public void preCreate()
	{
		this.createDate = new Date();
	}
	
	@PreUpdate
	public void preUpdate()
	{
		this.updateDate = new Date();
	}


	private static final long serialVersionUID = 2312938390464078462L;

}


