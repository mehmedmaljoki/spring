package com.mehmedmaljoki.springstarthere.wiring_beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter @Setter
public class AutowieringPersonLombock {
    
    private PersonsParrot parrot;
}
