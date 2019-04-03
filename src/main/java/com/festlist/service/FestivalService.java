package com.festlist.service;

import java.util.List;
import java.util.Optional;

import com.festlist.model.Festival;

public interface FestivalService {
	
	Festival createFestival(Festival festival);
	Optional<Festival> getFestival(Long id);
	Festival getFestivalByName(String name);
	Festival editFestival(Festival festival);
	void deleteFestival(Festival festival);
	void deleteFestival(Long id);
	List <Festival> getAllFestivals();

}
