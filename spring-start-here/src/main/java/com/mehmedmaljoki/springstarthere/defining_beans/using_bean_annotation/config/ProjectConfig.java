package com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.config;

import com.mehmedmaljoki.springstarthere.defining_beans.using_bean_annotation.entities.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    
    @Bean
    public Parrot parrot(){
        var p = new Parrot();
        p.setName("parrot");
        return p;
    }
}
