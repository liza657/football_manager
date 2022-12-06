package com.example.football_manager_web.service;

import com.example.football_manager_web.entity.Player;
import com.example.football_manager_web.entity.Team;
import com.example.football_manager_web.repository.PlayerRepository;
import com.example.football_manager_web.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Player> findPlayers() {
        List<Player> list = new ArrayList<>();
        playerRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Player getPlayer(Integer id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.findById(id).ifPresent(playerRepository::delete);
    }

    @Override
    public void transfer(Player player, Team teamSeller, Team teamBuyer) {
        int playerCost = player.getExperience() * 100000 / player.getAge();
        int commission = teamSeller.getCommission();

        int transferCost = playerCost + commission;

        int buyerBudget = teamBuyer.getBudget() - transferCost;
        int sellerBudget = teamSeller.getBudget() + transferCost;

        Player player1 = new Player(player.getId(),
                player.getName(),
                player.getAge(),
                player.getExperience(),
                teamBuyer);
        playerRepository.save(player1);

        Team teamSeller1 = new Team(teamSeller.getId(),
                teamSeller.getName(),
                sellerBudget,
                teamSeller.getCommission(),
                teamSeller.getPlayers());
        teamRepository.save(teamSeller1);

        Team teamBuyer1 = new Team(teamBuyer.getId(),
                teamBuyer.getName(),
                buyerBudget,
                teamBuyer.getCommission(),
                teamBuyer.getPlayers());
        teamRepository.save(teamBuyer1);

    }


}
