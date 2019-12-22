package com.psych.game.contoller;


import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerRepository PlayerRepo;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){

        return PlayerRepo.findAll();

    }
    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player){

       return PlayerRepo.save(player);

    }
    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(value="id") Long id) throws Exception{
        return PlayerRepo.findById(id).orElseThrow(() -> new Exception("something went wrong"));
    }
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value="id") Long id,@Valid @RequestBody Player player) throws Exception{
        Player p = PlayerRepo.findById(id).orElseThrow(() -> new Exception("something went wrong"));

        p.setName(player.getName());

        return PlayerRepo.save(p);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") Long id) throws Exception {
        Player p = PlayerRepo.findById(id).orElseThrow(() -> new Exception("something went wrong"));
        PlayerRepo.delete(p);
        return ResponseEntity.ok().build();
    }
}
