package com.example.football_manager_web.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer budget;
    private Integer commission;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = {CascadeType.ALL})
    private List<Player> players;


}
