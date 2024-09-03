package com.CristhianBaronaProjects.IntroSpringDataJpa;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository.CustomerCrudRepository;
import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Autowired
	private CustomerCrudRepository customerCrudRepository;

	@Bean
	public CommandLineRunner testCustomerRepositoryComand(){
		return args -> {
			Customer juan = new Customer();
			juan.setName("Juan Lopez");
			juan.setPassword("Juan123");

			customerCrudRepository.save(juan);

			System.out.println("Se guardo la entidad juan");

			System.out.println("\n Imprimiendo todos los clientes.");
			customerCrudRepository.findAll().forEach(
					System.out::println
			);

			System.out.println("\n buscando e imprimiendo a cliente juan");
			Optional<Customer> customerOpt = customerCrudRepository.findById(1L);
			customerOpt.ifPresent(System.out::println);

			System.out.println("\n eliminado al cliente juan");
			customerCrudRepository.deleteById(1L);
			
		};
	}
}
