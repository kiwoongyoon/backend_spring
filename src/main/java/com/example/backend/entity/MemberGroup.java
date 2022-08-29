package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member_group")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String name;
}