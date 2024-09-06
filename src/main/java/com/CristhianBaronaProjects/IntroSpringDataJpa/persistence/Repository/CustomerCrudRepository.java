package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<Customer, Long> {

    Customer searchByUsername(String username);

    Optional<Customer> findByUsername(String username);

    // select c.* from customer c where c.name like %?%
    List<Customer> findBynamecontaining(String name);

    // select c.* from customer c where c.name like ?%
    List<Customer> queryBynameStartsWith(String name);

    // select c.* from customer c where c.name like %?
    List<Customer> readBynameEndingWith(String name);

    //select c.* from customer c where c.name like %?1% and c.id >?2 order by is descendiente
    List<Customer> findBynamecontainingandidAndIdGreaterThanEqualOrderByDesc(String name, Long id)

}
