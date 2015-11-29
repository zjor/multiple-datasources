package edu.springlabs.service;

import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractService<T> {

    protected abstract EntityManager em();

    public abstract T create(T entity);

    public T get(String id) {
        return em().find(getClazz(), id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(getClazz());
        return em().createQuery(q.select(q.from(getClazz()))).getResultList();
    }

    private Class<T> getClazz() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractService.class);
    }

}
