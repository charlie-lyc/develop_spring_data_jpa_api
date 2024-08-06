package com.ems.rehearse1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 1. First
 *  - auto generate setters
 *  - auto generate getters
 *  - apply JPA entity
 *  - apply JPA table name
 */
@Setter
@Getter
@Entity
@Table(name = "Members")
public class Member {

    @Id                                                 // JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA
    private Long id;

    @Column(name = "name")                              // JPA
    private String name;

    @Column(name = "age")                               // JPA
    private Integer age;


//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

}
