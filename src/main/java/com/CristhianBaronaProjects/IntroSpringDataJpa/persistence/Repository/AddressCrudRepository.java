package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.Repository;

import com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressCrudRepository extends JpaRepository<Adress, Long> {
}
