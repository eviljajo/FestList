package com.festlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festlist.model.Festival;



@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {
	


}
