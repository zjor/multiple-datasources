package edu.springlabs.core.service;

import edu.springlabs.core.model.User;
import edu.springlabs.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService extends AbstractService<User> {

    @PersistenceContext(unitName = "coreEntityManagerFactory")
    private EntityManager em;

    @Override
    protected EntityManager em() {
        return em;
    }

    @Override
    @Transactional("coreTransactionManager")
    public User create(User user) {
        return em.merge(user);
    }

}
