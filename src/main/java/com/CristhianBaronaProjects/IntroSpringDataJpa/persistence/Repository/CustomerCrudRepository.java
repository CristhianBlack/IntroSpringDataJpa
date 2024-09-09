package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


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
    List<Customer> findBynamecontainingandidAndIdGreaterThanEqualOrderByDesc(String name, Long id);

    @Query("select c from Customer c where c.name like %?1% and c.id >= ?2 order by c.id desc" )
    List<Customer> findAllByNameAndIdGreaterThan(String name, Long id);

    @Query(value = "select c.* from clientes c where c.nombre like %?1% and c.id >= ?2 order by c.username desc", nativeQuery = true )
    List<Customer> findAllByNameAndIdGreaterThanUsingNativeSql(String name, Long id);
}
