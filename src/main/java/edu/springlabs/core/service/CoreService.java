package edu.springlabs.core.service;

import edu.springlabs.core.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Service
public class CoreService {

    @Inject
    private EntityManager em;

    public EntityManager em() {
        return em;
    }

    @Transactional
    public User createUser(User user) {
        return em.merge(user);
    }


}
