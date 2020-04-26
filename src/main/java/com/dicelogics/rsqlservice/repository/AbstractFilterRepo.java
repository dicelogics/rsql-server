package com.dicelogics.rsqlservice.repository;

import com.github.tennaito.rsql.jpa.JpaCriteriaQueryVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractFilterRepo<E> implements FilterRepo<E> {

    public List<E> findByQuery(String rsQuery) {
        CriteriaQuery<E> filteringCriteria = createFilteringCriteria(rsQuery);
        TypedQuery<E> query = getEntityManager().createQuery(filteringCriteria);
        return query.getResultList();
    }

    private CriteriaQuery<E> createFilteringCriteria(String queryString) {
        RSQLVisitor<CriteriaQuery<E>, EntityManager> visitor = getJpaCriteriaQueryVisitor();
        CriteriaQuery<E> query = getCriteriaQuery(queryString, visitor);
        return query;
    }

    @SneakyThrows
    private <T> CriteriaQuery<T> getCriteriaQuery(String queryString, RSQLVisitor<CriteriaQuery<T>, EntityManager> visitor) {
        Node rootNode;
        rootNode = new RSQLParser().parse(queryString);
        return rootNode.accept(visitor, getEntityManager());
    }

    protected abstract JpaCriteriaQueryVisitor<E> getJpaCriteriaQueryVisitor();

    protected abstract EntityManager getEntityManager();
}
