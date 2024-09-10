package com.CristhianBaronaProjects.IntroSpringDataJpa;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository.CustomerCrudRepository;
import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Adress;
import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Autowired
	private CustomerCrudRepository customerCrudRepository;

	@Bean
	public CommandLineRunner testQueryMethodCommand(){
		return args -> {


			Customer juan = new Customer();
			juan.setName("Juan Lopez");
			juan.setPassword("Juan123");
			juan.setUsername("Juan123");

			Adress juanAdressOne = new Adress();
			juanAdressOne.setCountry("El salvador");
			juanAdressOne.setAddress("casa 123 calle principal");


			Adress juanAdresstwo = new Adress();
			juanAdresstwo.setCountry("Honduras");
			juanAdresstwo.setAddress("casa 123 calle principal b");
			juan.setAdresses(List.of(juanAdressOne,juanAdresstwo));


			customerCrudRepository.save(juan);


		};
	}
}
