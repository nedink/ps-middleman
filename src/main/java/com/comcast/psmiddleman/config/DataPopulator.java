package com.comcast.psmiddleman.config;

import com.comcast.psmiddleman.repository.MyEntityRepository;
import com.comcast.psmiddleman.domain.MyEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataPopulator implements CommandLineRunner {

    private final MyEntityRepository myEntityRepository;

    @Override
    public void run(String... args) throws Exception {
        myEntityRepository.save(new MyEntity(null, "my name", 3));
        myEntityRepository.save(new MyEntity(null, "other name", 14));
        myEntityRepository.save(new MyEntity(null, "yet another name", 74));
    }
}
