package com.mehmedmaljoki.springstarthere.wiring_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowieringPerson {
    private String name = "AutowieringPerson";

    // adding the annotation over the field, 
    // you can't make the field final
    // not that easy to test
    // @Autowired
    private PersonsParrot parrot;
    
    // third way to inject
    @Autowired
    public AutowieringPerson( PersonsParrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public PersonsParrot getParrot() {
        return parrot;
    }

    // @Autowired
    // second way to inject the dependency
    public void setParrot(PersonsParrot parrot) {
        this.parrot = parrot;
    }
}
