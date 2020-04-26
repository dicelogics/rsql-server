package com.dicelogics.rsqlservice.repository;

import com.dicelogics.rsqlservice.model.Order;
import com.github.tennaito.rsql.jpa.JpaCriteriaQueryVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class OrderFilterRepo extends AbstractFilterRepo<Order> {

    private final EntityManager entityManager;

    @Autowired
    public OrderFilterRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    protected JpaCriteriaQueryVisitor<Order> getJpaCriteriaQueryVisitor() {
        return new JpaCriteriaQueryVisitor<Order>();
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
