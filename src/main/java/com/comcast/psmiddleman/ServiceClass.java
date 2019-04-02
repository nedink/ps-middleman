package com.comcast.psmiddleman;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceClass {

    private final MyEntityRepository myEntityRepository;

    public void doSomething() {
    }
}
