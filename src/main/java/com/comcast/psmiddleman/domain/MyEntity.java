package com.comcast.psmiddleman.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer number;
}
