package com.example.football_manager_web.repository;

import com.example.football_manager_web.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlayerRepository extends CrudRepository<Player, Integer> {


}
