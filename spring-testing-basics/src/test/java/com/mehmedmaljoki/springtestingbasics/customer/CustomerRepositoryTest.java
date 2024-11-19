package com.mehmedmaljoki.springtestingbasics.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void shouldSaveAndRetrieveJpaEntity() {
        Customer customerToStore = new Customer();
        customerToStore.setName("mike");
        customerToStore.setJoinedAt(ZonedDateTime.now());

        Customer result = testEntityManager.persistFlushFind(customerToStore);

        assertNotNull(result.getId());
    }
}
