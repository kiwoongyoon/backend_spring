package com.example.backend.entity;


import lombok.*;
import java.util.List ;
import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder=true)
@Table(name="member")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    @Column(length=128)
    private String pw ;
    @Column(length=64)
    private String name ;
    @ManyToOne
    @JoinColumn(name="member_group")
    private MemberGroup group;
    @ManyToMany
    @JoinTable(name = "member_book")
    private List<Book> books;
}
