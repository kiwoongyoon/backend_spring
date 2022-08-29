package com.example.backend.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;


}