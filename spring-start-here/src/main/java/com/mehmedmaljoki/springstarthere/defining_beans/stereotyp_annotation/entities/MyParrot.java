package com.mehmedmaljoki.springstarthere.defining_beans.stereotyp_annotation.entities;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MyParrot {
    
    private String name;
    
    @PostConstruct
    void init() {
        this.name = "MyParrot"; 
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String parrot) {
        this.name = parrot;
    }

    @Override
    public String toString() {
        return "MyParrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
