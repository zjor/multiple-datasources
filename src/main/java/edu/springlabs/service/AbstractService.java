package edu.springlabs.service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractService<T> {

    protected abstract EntityManager em();

    public abstract T create(T entity);

    public T get(Class<T> clazz, String id) {
        return em().find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(clazz);
        return em().createQuery(q.select(q.from(clazz))).getResultList();
    }

}
