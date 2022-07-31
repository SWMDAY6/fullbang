package day6.fullbang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import day6.fullbang.domain.Place;
import day6.fullbang.dto.response.PlaceInfoDto;
import day6.fullbang.service.PlaceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlaceController {

	private final PlaceService placeService;

	@GetMapping("/location")
	public List<PlaceInfoDto> readAllPlace(){
		List<Place> places = placeService.findAll();

		List<PlaceInfoDto> infos = new ArrayList<>();
		for (Place place : places) {
			PlaceInfoDto item = new PlaceInfoDto(place, place.getAddress());
			infos.add(item);
		}
		return infos;
	}

	// 모텔만 조회
	@GetMapping("/location/motel")
	public List<PlaceInfoDto> readMotelPlace(){
		List<Place> places = placeService.findMotelAll();

		List<PlaceInfoDto> infos = new ArrayList<>();
		for (Place place: places){
			PlaceInfoDto item = new PlaceInfoDto(place, place.getAddress());
			infos.add(item);
		}
		return infos;
	}

	// 호텔만 조회
	@GetMapping("/location/hotel")
	public List<PlaceInfoDto> readHotelPlace(){
		List<Place> places = placeService.findHotelAll();

		List<PlaceInfoDto> infos = new ArrayList<>();
		for (Place place: places){
			PlaceInfoDto item = new PlaceInfoDto(place, place.getAddress());
			infos.add(item);
		}
		return infos;
	}
	// 펜션만 조회
	@GetMapping("/location/pension")
	public List<PlaceInfoDto> readPensionPlace(){
		List<Place> places = placeService.findPensionAll();

		List<PlaceInfoDto> infos = new ArrayList<>();
		for (Place place: places){
			PlaceInfoDto item = new PlaceInfoDto(place, place.getAddress());
			infos.add(item);
		}
		return infos;
	}
	// 게스트하우스만 조회
	@GetMapping("/location/guest-house")
	public List<PlaceInfoDto> readGuestHousePlace(){
		List<Place> places = placeService.findGuestHouseAll();

		List<PlaceInfoDto> infos = new ArrayList<>();
		for (Place place: places){
			PlaceInfoDto item = new PlaceInfoDto(place, place.getAddress());
			infos.add(item);
		}
		return infos;
	}
}
