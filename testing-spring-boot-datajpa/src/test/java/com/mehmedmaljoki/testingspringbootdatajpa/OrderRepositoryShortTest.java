package com.mehmedmaljoki.testingspringbootdatajpa;


import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest( // override properties
        properties = {
                "spring.test.database.replace=NONE",
                // tc = testcontainers
                // specify the database version
                "spring.datasource.url=jdbc:tc:postgresql:16:///springboot"
        })
class OrderRepositoryShortTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Sql("/scripts/INIT_THREE_ORDERS.sql")
    void shouldReturnOrdersThatContainMacBookPro() {
        List<Order> orders = orderRepository.findAllContainingMacBookPro();
        assertEquals(2, orders.size());
    }
}
