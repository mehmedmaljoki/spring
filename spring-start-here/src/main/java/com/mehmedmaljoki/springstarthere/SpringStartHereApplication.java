package com.mehmedmaljoki.springstarthere;

import com.mehmedmaljoki.springstarthere.defining_beans.ProjectConfig;
import com.mehmedmaljoki.springstarthere.defining_beans.stereotyp_annotation.entities.MyParrot;
import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities.Parrot;
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


        // By default spring does not know any of the objects you define.
        // you have to tell spring -> put them into the context(becomes a bean)
        // Context = instances that are managed by spring
        // Spring Container = to implement the context
//        SpringApplication.run(SpringStartHereApplication.class, args);
    }

}
