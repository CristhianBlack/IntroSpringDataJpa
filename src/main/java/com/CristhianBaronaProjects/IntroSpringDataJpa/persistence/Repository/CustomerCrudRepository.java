package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<Customer, Long> {


}
