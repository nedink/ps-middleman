package com.comcast.psmiddleman.repository;

import com.comcast.psmiddleman.domain.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}
