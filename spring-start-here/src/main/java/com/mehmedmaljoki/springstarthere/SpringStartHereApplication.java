package com.mehmedmaljoki.springstarthere;

import com.mehmedmaljoki.springstarthere.defining_beans.stereotyp_annotation.entities.MyParrot;
import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities.Parrot;
import com.mehmedmaljoki.springstarthere.wiring_beans.AutowieringPerson;
import com.mehmedmaljoki.springstarthere.wiring_beans.AutowieringPersonLombock;
import com.mehmedmaljoki.springstarthere.wiring_beans.Person;
import com.mehmedmaljoki.springstarthere.wiring_beans.PersonsParrot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class SpringStartHereApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(
                ProjectConfig.class);
        

        // get bean by type and name
        var parrot = context.getBean("parrot", Parrot.class);

        // can only create one instance from stereotypes
        var myParrot = context.getBean(MyParrot.class);

        Parrot x = new Parrot();
        x.setName("x");
        
        // add through register Bean
        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot2", Parrot.class, parrotSupplier);
        
        log.info("Context is created {}", parrot.getName());
        log.info("Context is created {}", myParrot.getName());
        log.info("Context is created {}", context.getBean("parrot2", Parrot.class).getName());
        
        
        var personsPirrot = context.getBean("personsParrot", PersonsParrot.class);
        var person = context.getBean("person", Person.class);
        
        log.info("Context is created {}", personsPirrot.getName());
        log.info("Context is created {} and the person has {}", person.getName(), person.getParrot().getName());


        var person2 = context.getBean("person2", Person.class);
        log.info("Context is created {} and the person has {}", person2.getName(), person2.getParrot().getName());
        
        var autowiredPerson = context.getBean(AutowieringPerson.class);
        log.info("Context is created {} and the person has {}", autowiredPerson.getName(), autowiredPerson.getParrot().getName());
        
        var autoWieringLombokPerson = context.getBean(AutowieringPersonLombock.class);
        log.info("Context is created {} and the person has {}", autoWieringLombokPerson, autoWieringLombokPerson.getParrot().getName());


        // By default spring does not know any of the objects you define.
        // you have to tell spring -> put them into the context(becomes a bean)
        // Context = instances that are managed by spring
        // Spring Container = to implement the context
//        SpringApplication.run(SpringStartHereApplication.class, args);
    }

}
