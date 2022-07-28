package com.example.football_manager_web.service;
import com.example.football_manager_web.entity.Team;
import com.example.football_manager_web.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;


    @Override
    public List<Team> findTeams() {
        List<Team> list = new ArrayList<>();
        teamRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Team getTeam(Integer id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);

    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);

    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.findById(id).ifPresent(teamRepository::delete);
    }


}
