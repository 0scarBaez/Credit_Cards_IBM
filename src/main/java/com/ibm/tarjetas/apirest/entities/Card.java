package com.ibm.tarjetas.apirest.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "cads", schema = "bank")
public class Card implements Serializable
{
	//ATRIBUTOS
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name = "name", unique = true, nullable = false)
		private String nombre;
		
	//RELACIONES
		@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(
			name = "card_client", schema = "bank",
			joinColumns = @JoinColumn(name = "card_id"),
			inverseJoinColumns = @JoinColumn(name = "client_id")
		)
		private Set<Client> clientes;
		
		//CONSTRUCTOR
		
		public Card(Integer id, String nombre) {
			this.id = id;
			this.nombre = nombre;
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
			Card other = (Card) obj;
			return Objects.equals(id, other.id);
		}




	private static final long serialVersionUID = -4293822306025581406L;

	
}
