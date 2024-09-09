package com.CristhianBaronaProjects.IntroSpringDataJpa;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository.CustomerCrudRepository;
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

			Customer ramon = new Customer();
			ramon.setName("Ramon Hernandez");
			ramon.setPassword("ramon123");
			ramon.setUsername("ramon123");


			Customer luis = new Customer();
			luis.setName("Luis Marquez");
			luis.setPassword("luism123");
			luis.setUsername("luism123");

			Customer luis2= new Customer();
			luis.setName("Luis cañaz");
			luis.setPassword("luisc123");
			luis.setUsername("luisc123");


			System.out.println("Se guardaron 3 entidades");
			List<Customer> clientes = List.of(juan, ramon, luis, luis2);
			customerCrudRepository.saveAll(clientes);

			//Pruebas video 1
			//System.out.println("\n probando Query method findByusername");
			//System.out.println(customerCrudRepository.searchByUsername("luism123"));

			//Pruebas video 2
			System.out.println("\n nombre que contienen la letra o");
			customerCrudRepository.findBynamecontaining("o").
					forEach(System.out::println);

			System.out.println("\n nombre que empiecen la letra R");
			customerCrudRepository.queryBynameStartsWith("R").
					forEach(System.out::println);

			System.out.println("\n nombre que terminen con las palabra ez");
			customerCrudRepository.readBynameEndingWith("ez").
					forEach(System.out::println);

			System.out.println("\n nombre que contiene ez y cuyo id sea mayor o igaul que 3 ");
			customerCrudRepository.findBynamecontainingandidAndIdGreaterThanEqualOrderByDesc("ez", 3l).
					forEach(System.out::println);

			System.out.println("\n nombre que contiene ez y cuyo id sea mayor o igaul que 3 utilizando JPQL y la anotacion @Query  ");
			customerCrudRepository.findAllByNameAndIdGreaterThan("ez", 3l).
					forEach(System.out::println);

			System.out.println("\n nombre que contiene ez y cuyo id sea mayor o igaul que 3 utilizando SQL Nativo ");
			customerCrudRepository.findAllByNameAndIdGreaterThanUsingNativeSql("ez", 3l).
					forEach(System.out::println);
		};
	}
}
