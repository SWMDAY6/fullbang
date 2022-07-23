package day6.fullbang.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import day6.fullbang.domain.Product;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private EntityManager em;

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }
}
