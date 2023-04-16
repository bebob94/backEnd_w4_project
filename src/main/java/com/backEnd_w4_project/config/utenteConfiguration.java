package com.backEnd_w4_project.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.backEnd_w4_project.model.Edificio;
import com.backEnd_w4_project.model.Postazione;
import com.backEnd_w4_project.model.Utente;
import com.github.javafaker.Faker;

@Configuration
@PropertySource("classpath:application.properties")
public class utenteConfiguration {

	
	@Bean
	@Scope("prototype")
	public Utente customUtente() {
		return new Utente();
	}
	
	@Bean
	@Scope("prototype")
	public Utente paramUtente(String userName, String nomeCompleto, String email) {
		return new Utente(userName,nomeCompleto,email);
	}
	
	@Bean("UtenteFake")
	@Scope("prototype")
	public Utente fakeUtente(Postazione postazione) {
		Faker fake= Faker.instance(new Locale("it-IT"));
	Utente u = new Utente();
	u.setNomeCompleto(fake.funnyName().name());
	u.setUserName(u.getNomeCompleto() +fake.idNumber());
	u.setEmail(u.getNomeCompleto() + "@example.com");
	return u;
	}
	
}
