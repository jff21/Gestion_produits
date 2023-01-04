package com.product.product_backend.Specification;

import com.product.product_backend.Models.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecifications {

    public static Specification<Product>getSpec(String mark, String designation, String reference) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (mark != null && !(mark.isEmpty()))
                predicates.add(criteriaBuilder.equal(root.get("mark"), mark));
            if(designation!= null && !(designation.isEmpty()))
                predicates.add(criteriaBuilder.equal(root.get("designation"),designation));
            if(reference!= null && !(reference.isEmpty()))
                predicates.add(criteriaBuilder.equal(root.get("reference"),reference));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
