package com.mehmedmaljoki.springstarthere;

import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities.Parrot;
import com.mehmedmaljoki.springstarthere.wiring_beans.Person;
import com.mehmedmaljoki.springstarthere.wiring_beans.PersonsParrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.mehmedmaljoki.springstarthere"})
@Configuration
public class ProjectConfig {
    
    @Bean(name = "parrot")
    public Parrot parrot(){
        var p = new Parrot();
        p.setName("parrot");
        return p;
    }

    @Bean(name = "parrot2")
    public Parrot parrot2(){
        var p = new Parrot();
        p.setName("parrot");
        return p;
    }
    
    @Bean
    public PersonsParrot personsParrot(){
        PersonsParrot p = new PersonsParrot();
        p.setName("PersonsParrot");
        return p;
    }
    
    @Bean
    public Person person(){
        Person p = new Person();
        p.setName("Person");
        // first way establish a has_A relationship
        p.setParrot(personsParrot());
        return p;
    }

    // second way to establish a has_A relationship
    @Bean
    public Person person2(PersonsParrot personsParrot){
        Person p = new Person();
        p.setName("Person2");
        // first way establish a has_A relationship
        p.setParrot(personsParrot);
        return p;
    }
}
