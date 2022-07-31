package day6.fullbang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import day6.fullbang.domain.Place;
import day6.fullbang.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> findByAddressCode(String addressCodeHead) {
        return placeRepository.findByAddressCode(addressCodeHead);
    }
}
