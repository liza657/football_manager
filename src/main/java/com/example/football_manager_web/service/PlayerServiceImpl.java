package com.example.football_manager_web.service;
import com.example.football_manager_web.entity.Player;
import com.example.football_manager_web.repository.PlayerRepository;
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

}
