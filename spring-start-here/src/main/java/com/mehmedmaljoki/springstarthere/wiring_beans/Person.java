package com.mehmedmaljoki.springstarthere.wiring_beans;

public class Person {
    private String name;
    private PersonsParrot parrot;

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setParrot(PersonsParrot parrot) {
        this.parrot = parrot;
    }
    
    public PersonsParrot getParrot() {
        return parrot;
    }
}
