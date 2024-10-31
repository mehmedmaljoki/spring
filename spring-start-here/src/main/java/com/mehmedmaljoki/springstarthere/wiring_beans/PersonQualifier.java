package com.mehmedmaljoki.springstarthere.wiring_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonQualifier {
    private String name = "PersonQualifier";

    private final PersonsParrot parrot;

    public PersonQualifier(@Qualifier("personsParrot") PersonsParrot parrot) {
        this.parrot = parrot;
    }
}
