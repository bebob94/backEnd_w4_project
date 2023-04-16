package com.backEnd_w4_project.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "utenti")
public class Utente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtente;
	
	@Column(nullable = false, unique = true)
	private String userName;
	private String nomeCompleto;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
	private List<Prenotazione> prenotazioni;
	
	
	public Utente(String userName, String nomeCompleto, String email) {
		super();
		this.userName = userName;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}
	
	
}
