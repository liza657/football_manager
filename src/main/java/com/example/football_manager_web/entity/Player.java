package com.example.football_manager_web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer height;
    private Integer age;
    private Integer experience;
    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name = "team_id")
    private Team team;


}

