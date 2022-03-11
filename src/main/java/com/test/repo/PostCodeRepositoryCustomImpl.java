package com.test.repo;

import com.test.entity.PostCode;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostCodeRepositoryCustomImpl implements PostCodeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    public PostCode findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostCode> cq = cb.createQuery(PostCode.class);
        Root<PostCode> postcode = cq.from(PostCode.class);
        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
            predicates.add(cb.equal(postcode.get("postalCode"), name));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        List<PostCode> postcodes = entityManager.createQuery(cq).getResultList();
        return (postcodes != null && postcodes.size() > 0) ? postcodes.get(0) : null;
    }
}
