package edu.springlabs;

import edu.springlabs.core.model.User;
import edu.springlabs.core.service.UserService;
import edu.springlabs.product.model.Product;
import edu.springlabs.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-context-application.xml", "classpath:spring-context-test-*.xml"})
public class AppTest {

    @Inject
    private UserService userService;

    @Inject
    private ProductService productService;

    @Test
    @Transactional("coreTransactionManager")
    public void shouldCreateAndFetchUsers() {
        String id = userService.create(new User()).getId();
        Assert.assertTrue(userService.findAll().stream().filter(u -> u.getId().equals(id)).count() > 0);
    }

    @Test
    @Transactional("productTransactionManager")
    public void shouldCreateAndFetchProducts() {
        String id = productService.create(new Product("Acme Product")).getId();
        Assert.assertTrue(productService.findAll().stream().filter(p -> p.getId().equals(id)).count() > 0);
    }

}
