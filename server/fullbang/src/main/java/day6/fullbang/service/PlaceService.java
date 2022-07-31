package day6.fullbang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import day6.fullbang.domain.Place;
import day6.fullbang.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlaceService {
	private final PlaceRepository placeRepository;

	public List<Place> findAll(){
		return placeRepository.findAll();
	}
	public List<Place> findMotelAll(){
		return placeRepository.findMotelAll();
	}
	public List<Place> findHotelAll(){
		return placeRepository.findHotelAll();
	}
	public List<Place> findPensionAll(){
		return placeRepository.findPensionAll();
	}
	public List<Place> findGuestHouseAll(){
		return placeRepository.findGuestHouseAll();
	}
}
