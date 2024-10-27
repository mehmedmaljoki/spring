package com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities;

public class Parrot {
    
    private String name;
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String parrot) {
        this.name = parrot;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
