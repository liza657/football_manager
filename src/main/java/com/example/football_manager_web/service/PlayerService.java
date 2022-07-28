package com.example.football_manager_web.service;
import com.example.football_manager_web.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findPlayers();

    Player getPlayer(Integer id);

    public void savePlayer(Player player);

    public Player updatePlayer(Player player);

    public void deletePlayer(Integer id);

}
