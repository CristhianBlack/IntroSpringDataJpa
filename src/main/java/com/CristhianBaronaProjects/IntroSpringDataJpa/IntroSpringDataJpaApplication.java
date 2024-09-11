package com.CristhianBaronaProjects.IntroSpringDataJpa;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository.AddressCrudRepository;
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

	@Autowired
	private AddressCrudRepository addressCrudRepository;

	@Bean
	public CommandLineRunner populateDataBaseCommand(){
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

			/*juan.setAdresses(List.of(juanAdressOne,juanAdresstwo));
			juanAdressOne.setCustomer(juan);
			juanAdresstwo.setCustomer(juan);*/


			juan.addAddress(juanAdressOne);
			juan.addAddress(juanAdresstwo);

			Customer luis = new Customer();
			luis.setName("Luis Marquez");
			luis.setPassword("luis123");
			luis.setUsername("luis123");

			Adress luisAdress = new Adress();
			luisAdress.setCountry("El salvador");
			luisAdress.setAddress("casa 123 calle principal");

			luis.addAddress(luisAdress);

			customerCrudRepository.saveAll(List.of(juan, luis));


		};
	}

	@Bean
	public CommandLineRunner testQueryMethodsAndJPQLExamplesCommand(){
		return args -> {

			System.out.println("\n Buscando clientes de honduras utilizando query method");
			customerCrudRepository.findByAdressesCountry("honduras")
					.forEach(System.out::println);

			System.out.println("\n Buscando clientes de el salvador utilizando JPQL");
			customerCrudRepository.findCustomerFrom("El salvador")
					.forEach(System.out::println);

			System.out.println("\n Buscando direcciones de clientes cuyos nombres terminen en ?: utilizando QueryMethods ");
			addressCrudRepository.findByCustomerNameEndsWith("ez")
					.forEach(System.out::println);

			System.out.println("\n Buscando direcciones cuyo nombre de cliente termine en ?: utilizando JPQL ");
			addressCrudRepository.findBYCustomerEndsWith("ez")
					.forEach(System.out::println);
		};
	}
}
