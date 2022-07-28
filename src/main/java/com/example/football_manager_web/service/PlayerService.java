package com.example.football_manager_web.service;

import com.example.football_manager_web.entity.Player;

import java.util.Set;

public interface PlayerService {
    public Player getPlayer(Integer id);
    Set<Player> retrieveAllPlayers();
}
