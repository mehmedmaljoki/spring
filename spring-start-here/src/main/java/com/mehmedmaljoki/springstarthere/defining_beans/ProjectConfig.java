package com.mehmedmaljoki.springstarthere.defining_beans;

import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.mehmedmaljoki.springstarthere.defining_beans"})
@Configuration
public class ProjectConfig {
    
    @Bean(name = "parrot")
    public Parrot parrot(){
        var p = new Parrot();
        p.setName("parrot");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        var p = new Parrot();
        p.setName("parrot");
        return p;
    }
}
