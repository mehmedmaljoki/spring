package com.mehmedmaljoki.springstarthere.defining_beans.stereotyp_annotation.entities;

import org.springframework.stereotype.Component;

@Component
public class MyParrot {
    
    private String name;
    
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
