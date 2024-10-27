package com.mehmedmaljoki.springstarthere;

import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.config.ProjectConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringStartHereApplication {

    public static void main(String[] args) {
        
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var parrot = context.getBean("parrot");
        log.info("Context is created {}", context.getBean("parrot"));
        
        
        // By default spring does not know any of the objects you define.
        // you have to tell spring -> put them into the context(becomes a bean)
        // Context = instances that are managed by spring
        // Spring Container = to implement the context
        SpringApplication.run(SpringStartHereApplication.class, args);
    }

}
