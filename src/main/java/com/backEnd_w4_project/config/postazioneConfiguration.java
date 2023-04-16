package com.backEnd_w4_project.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.backEnd_w4_project.enum_.TipoPostazione;
import com.backEnd_w4_project.model.Edificio;
import com.backEnd_w4_project.model.Postazione;
import com.github.javafaker.Faker;


@Configuration
@PropertySource("classpath:application.properties")
public class postazioneConfiguration {
	
	@Bean
	@Scope("prototype")
	public Postazione customPostazione() {
		return new Postazione();
	}
	
	
	@Bean
	@Scope("prototype")
	public Postazione paramPostazione(String descrizione, TipoPostazione tipoPostazione, int maxOccupanti, Edificio edificio, boolean PostazioneLibera) {
		return new Postazione(descrizione,tipoPostazione,maxOccupanti,edificio, PostazioneLibera);
	}
	
	@Bean("PostazioneFake")
	@Scope("prototype")
	public Postazione fakePostazione( Edificio edificio) {
		Faker fake= Faker.instance(new Locale("it-IT"));
		Postazione p = new Postazione();
		p.setDescrizione(fake.rockBand().name());
		int random = fake.number().numberBetween(2, 30);
		p.setMaxOccupanti(random);
		if(random <10) {
			p.setTipoPostazione(TipoPostazione.PRIVATO);
		}else if(random <20) {
			p.setTipoPostazione(TipoPostazione.OPEN_SPACE);
		}else {
			p.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
		}
		p.setPostazioneLibera(true);
		p.setEdificio(edificio);
		return p;
	}

}
