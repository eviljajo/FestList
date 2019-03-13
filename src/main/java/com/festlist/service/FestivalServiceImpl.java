package com.festlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.festlist.model.Festival;
import com.festlist.repositories.FestivalRepository;

@Service
public class FestivalServiceImpl implements FestivalService {

	@Autowired
	private FestivalRepository festivalRepository;
	
	
	@Override
	public Festival createFestival(Festival festival) {
	
		return festivalRepository.save(festival);
	}

	@Override
	public Optional<Festival> getFestival(Long id) {

		return festivalRepository.findById(id);
	}

	@Override
	public Festival editFestival(Festival festival) {
		
		return festivalRepository.save(festival);
	}

	@Override
	public void deleteFestival(Festival festival) {
		festivalRepository.delete(festival);
		
	}

	@Override
	public void deleteFestival(Long id) {
		festivalRepository.deleteById(id);
	}

	@Override
	public List<Festival> getAllFestivals() {
		
		return festivalRepository.findAll();
	}
	
	

	

}
