package com.comcast.psmiddleman;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}
