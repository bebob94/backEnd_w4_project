package com.backEnd_w4_project.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.backEnd_w4_project.model.Edificio;
import com.github.javafaker.Faker;


@Configuration
@PropertySource("classpath:application.properties")
public class edificioConfiguration {

	@Bean
	@Scope("prototype")
	public Edificio customEdificio() {
		return new Edificio();
	}

	
	@Bean("EdificioFake")
	@Scope("prototype")
	public Edificio fakeEdificio() {
		Faker fake= Faker.instance(new Locale("it-IT"));
		Edificio e = new Edificio();
		e.setCittà(fake.address().city());
		e.setIndirizzo(fake.address().fullAddress());
		e.setName(fake.company().name());
		return e;
				
	}
	
	
}
