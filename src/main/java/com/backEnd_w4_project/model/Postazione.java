package com.backEnd_w4_project.model;

import java.io.Serializable;
import java.util.List;

import com.backEnd_w4_project.enum_.TipoPostazione;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "postazioni")
public class Postazione implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostazione;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoPostazione  tipoPostazione;
	private int maxOccupanti;
	
	@ManyToOne
	private Edificio edificio;
	private boolean PostazioneLibera;
	
	
	
	
	public Postazione(String descrizione, TipoPostazione tipoPostazione, int maxOccupanti, Edificio edificio, boolean PostazioneLibera) {
		super();
		this.descrizione = descrizione;
		this.tipoPostazione = tipoPostazione;
		this.maxOccupanti = maxOccupanti;
		this.edificio = edificio;
		this.PostazioneLibera = PostazioneLibera;
	}



	
}
