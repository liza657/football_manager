package com.example.football_manager_web.service;

import com.example.football_manager_web.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface TeamService {
    List<Team> findTeams();
    public Team getTeam(Integer id);
    public void saveTeam(Team team);
    public void updateTeam(Team team);
    public void deleteTeam(Integer id);


}
