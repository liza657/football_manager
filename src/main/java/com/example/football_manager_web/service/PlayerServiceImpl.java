package com.example.football_manager_web.service;

import com.example.football_manager_web.entity.Player;
import com.example.football_manager_web.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional
    public Player getPlayer(Integer id) {
        return playerRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Set<Player> retrieveAllPlayers() {
        Set<Player> set = new HashSet<>();
        playerRepository.findAll().forEach(set::add);
        return set;
    }
}
