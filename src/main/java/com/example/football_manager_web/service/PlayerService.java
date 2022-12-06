package com.example.football_manager_web.service;
import com.example.football_manager_web.entity.Player;
import com.example.football_manager_web.entity.Team;

import java.util.List;

public interface PlayerService {
    List<Player> findPlayers();

    Player getPlayer(Integer id);

    public void savePlayer(Player player);

    public Player updatePlayer(Player player);

    public void deletePlayer(Integer id);
    public void transfer(Player player, Team from,Team to);

}
