package com.product.product_backend.Repositories;

import com.product.product_backend.DTOS.SearchContext;
import com.product.product_backend.Models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductRepoImpl implements ProductRepoCustum{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> FindSimilarProd(String mark) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        //select*from product
        Root<Product> productRoot =cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
           if(mark != null){
               predicates.add(cb.equal(productRoot.get("mark"),mark));
           }
          cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Product> Search(String mark, String designation, String reference) {
        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> productRoot =cq.from(Product.class);
        Predicate markPredicate= cb.like(productRoot.get("mark"),"%"+mark+"%");
        Predicate designationPredicate= cb.like(productRoot.get("designation"),"%"+designation+"%");
        Predicate descriptionPredicate= cb.like(productRoot.get("reference"),"%"+reference+"%");
        Predicate orPredicate= cb.or(markPredicate,descriptionPredicate,designationPredicate);
        cq.where(orPredicate);
        TypedQuery<Product> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Product> SearchBySearchcontext(SearchContext searchContext) {
        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        List<Predicate>predicates= new ArrayList<>();
        Root<Product> productRoot =cq.from(Product.class);
        if(searchContext.getReference()!= null){
            Predicate descriptionPredicate=cb.like(productRoot.get("reference")
                    ,"%"+searchContext.getReference()+"%");
            predicates.add(descriptionPredicate);
        }
        if(searchContext.getDesignation()!=null){
            Predicate designationPredicate=cb.like(productRoot.get("designation"),
                    "%"+searchContext.getDesignation()+"%");
            predicates.add(designationPredicate);
        }
        if(searchContext.getMark()!=null){
            Predicate markPredicate=cb.like(productRoot.get("mark"),"%"+searchContext.getMark()+"%");
        }
        cq.where(cb.or(predicates.toArray(new Predicate[0])));
        TypedQuery<Product> query = entityManager.createQuery(cq);
        return query.getResultList();
    }


}
