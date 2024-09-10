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

			Adress juanAdress = new Adress();
			juanAdress.setCountry("El salvador");
			juanAdress.setAddress("casa 123 calle principal");
			juan.setAdres(juanAdress);

			Customer ramon = new Customer();
			ramon.setName("Ramon Hernandez");
			ramon.setPassword("ramon123");
			ramon.setUsername("ramon123");

			Adress ramonAdress = new Adress();
			ramonAdress.setCountry("El salvador");
			ramonAdress.setAddress("calle abc calle principal");
			ramon.setAdres(ramonAdress);


			Customer luis = new Customer();
			luis.setName("Luis Marquez");
			luis.setPassword("luism123");
			luis.setUsername("luism123");

			Adress luisAdress = new Adress();
			luisAdress.setCountry("El salvador");
			luisAdress.setAddress("casa 123 calle principal");
			luis.setAdres(luisAdress);

			System.out.println("Se guardaron 3 entidades");
			List<Customer> clientes = List.of(juan, ramon, luis);
			customerCrudRepository.saveAll(clientes);


		};
	}
}
