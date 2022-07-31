package day6.fullbang.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import day6.fullbang.domain.Address;
import day6.fullbang.domain.Place;
import day6.fullbang.domain.Product;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;

    public Place findOne(Long id) {
        return em.find(Place.class, id);
    }

    public List<Place> findAll(){
        String query="select p from Place p join fetch p.address";
        return em.createQuery(query,Place.class).getResultList();
    }

    public List<Place> findMotelAll(){
        String query="select p from Place p join fetch p.address where p.type = '모텔'";
        return em.createQuery(query, Place.class).getResultList();
    }
    public List<Place> findHotelAll(){
        String query="select p from Place p join fetch p.address where p.type = '호텔'";
        return em.createQuery(query, Place.class).getResultList();
    }
    public List<Place> findPensionAll(){
        String query="select p from Place p join fetch p.address where p.type = '펜션'";
        return em.createQuery(query, Place.class).getResultList();
    }
    public List<Place> findGuestHouseAll(){
        String query="select p from Place p join fetch p.address where p.type = '게스트하우스'";
        return em.createQuery(query, Place.class).getResultList();
    }
}
