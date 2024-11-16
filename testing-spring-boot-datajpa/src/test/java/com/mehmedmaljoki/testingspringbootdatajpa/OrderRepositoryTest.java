package com.mehmedmaljoki.testingspringbootdatajpa;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // all Tests will be mapped in one transaction -> we have for each test a clean database
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // we don't want to replace the datasource
class OrderRepositoryTest {
    
    @Container
    static PostgreSQLContainer database = new PostgreSQLContainer("postgres:16.1")
            .withDatabaseName("springboot")
            .withUsername("springboot")
            .withPassword("springboot");
    

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
    }

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testDatabaseConnection() throws SQLException {
        assertThat(database.isRunning()).isTrue();
        assertThat(database.getJdbcUrl()).startsWith("jdbc:postgresql://localhost:");
        assertThat(dataSource.getConnection()).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(orderRepository).isNotNull();
    }
    
    @Test
    void contextLoads() {
        assertThat(entityManager).isNotNull();
        assertThat(dataSource).isNotNull();
    }

    @Test
    void validateDatabaseProperties() {
        String expectedJdbcUrlPrefix = "jdbc:postgresql://localhost:";
        assertThat(database.getJdbcUrl()).startsWith(expectedJdbcUrlPrefix);
        assertThat(database.getJdbcUrl()).contains("/springboot");
    }

    @Test
    void validateJdbcUrl() {
        assertThat(database.getJdbcUrl()).contains("localhost");
        assertThat(database.getJdbcUrl()).contains("springboot");
    }

    @Test
    void shouldReturnOrdersThatContainMacBookPro() {

        orderRepository.save(
                createOrder(
                        "42",
                        """
                                   [{"name": "MacBook Pro", "amount" : 42}, {"name": "iPhone Pro", "amount" : 42}]
                                """));

        orderRepository.save(
                createOrder(
                        "43",
                        """
                                   [{"name": "Kindle", "amount" : 13}, {"name": "MacBook Pro", "amount" : 10}]
                                """));

        orderRepository.save(createOrder("44", "[]"));

        List<Order> orders = orderRepository.findAllContainingMacBookPro();

        assertEquals(2, orders.size());
    }

    private Order createOrder(String trackingNumber, String items) {
        var order = new Order();
        order.setTrackingNumber(trackingNumber);
        order.setItems(items);
        return order;
    }
}
