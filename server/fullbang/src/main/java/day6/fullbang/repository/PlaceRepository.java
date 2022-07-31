package day6.fullbang.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import day6.fullbang.domain.Place;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PlaceRepository {

    private final EntityManager em;

    public Place findOne(Long id) {
        return em.find(Place.class, id);
    }

    public List<Place> findByAddressCode(String addressCodeHead) {
        String addressCodeRegex = addressCodeHead + '%';
        return em.createQuery("select p from Place p where p.address.addressCode like :addressCodeRegex",
            Place.class)
            .setParameter("addressCodeRegex", addressCodeRegex)
            .getResultList();
    }
}
