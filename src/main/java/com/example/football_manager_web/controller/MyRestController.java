package com.example.football_manager_web.controller;

import com.example.football_manager_web.entity.Player;
import com.example.football_manager_web.entity.Team;
import com.example.football_manager_web.service.PlayerService;
import com.example.football_manager_web.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class MyRestController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;


    @GetMapping("/teams")
    public List<Team> showAllTeams() {
        return teamService.findTeams();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable Integer id) {
        return teamService.getTeam(id);
    }

    @PostMapping("/teams")
    public ResponseEntity<String> saveTeam(@RequestBody Team team) {
        teamService.saveTeam(team);
        return ResponseEntity.ok().body(String.format("team:[{}] was successfully added", team));
    }

    @PutMapping("/teams")
    public ResponseEntity<String> updateTeam(@RequestBody Team team) {
        teamService.updateTeam(team);
        return ResponseEntity.ok().body(String.format("team with id:%d was successfully updated", team.getId()));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok().body(String.format("team with id:%d was successfully deleted", id));

    }


    @GetMapping("/players")
    public List<Player> findPlayers() {
        return playerService.findPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable Integer id) {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public ResponseEntity<String> savePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return ResponseEntity.ok().body(String.format("player:[{}] was successfully added", player));

    }

    @PutMapping("/players")
    public ResponseEntity<String> updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
        return ResponseEntity.ok().body(String.format("player:[{}] was successfully updated", player));

    }

    @DeleteMapping("players/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok().body(String.format("player with id:%d was successfully deleted", id));
    }

    @PutMapping("/transfer")
    public void transfer(@RequestBody Player player,@RequestBody Team sellerTeam, @RequestBody Team buyerTeam) {
        playerService.updatePlayer(player);
        teamService.updateTeam(sellerTeam);
        teamService.updateTeam(buyerTeam);
    }
}
