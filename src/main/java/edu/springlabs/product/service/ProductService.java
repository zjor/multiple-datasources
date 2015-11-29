package edu.springlabs.product.service;

import edu.springlabs.product.model.Product;
import edu.springlabs.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProductService extends AbstractService<Product> {

    @PersistenceContext(unitName = "productEntityManagerFactory")
    private EntityManager em;

    @Override
    protected EntityManager em() {
        return em;
    }

    @Override
    @Transactional("productTransactionManager")
    public Product create(Product user) {
        return em.merge(user);
    }

}
