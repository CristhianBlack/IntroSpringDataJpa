package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AddressCrudRepository extends JpaRepository<Adress, Long> {

    List<Adress> findByCustomerNameEndsWith(String customerName);

    @Query("select addr from address addr join customer c where c.name like %?1" )
    List<Adress> findBYCustomerEndsWith(String customerName);
}
