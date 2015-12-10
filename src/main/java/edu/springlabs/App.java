package edu.springlabs;

import edu.springlabs.core.model.User;
import edu.springlabs.core.service.CoreService;
import edu.springlabs.core.service.UserService;
import edu.springlabs.product.model.Product;
import edu.springlabs.product.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-*.xml");
        UserService userService = ctx.getBean(UserService.class);
        ProductService productService = ctx.getBean(ProductService.class);

        CoreService coreService = ctx.getBean(CoreService.class);

        userService.create(new User());
        productService.create(new Product("Acme Product"));
        coreService.createUser(new User());

        ((AbstractApplicationContext)ctx).close();
    }
}
