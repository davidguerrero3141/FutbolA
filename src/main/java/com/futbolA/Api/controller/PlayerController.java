package com.futbolA.Api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futbolA.Api.entity.Player;
import com.futbolA.Api.services.PlayerService;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	
	 @GetMapping
	 public List<Player> readAll(){
		 List<Player> players = StreamSupport
				 .stream(playerService.findAll().spliterator(), false)
				 .collect(Collectors.toList());
		 return players;
	 }
	
	@PostMapping
	public ResponseEntity<?> create ( @RequestBody Player player){
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(player));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Player> oPlayer = playerService.findById(id);
		if(!oPlayer.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(oPlayer);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Player playerDetails, @PathVariable Long id){
		Optional<Player> player = playerService.findById(id);
		if(!player.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		player.get().setNumero_documento(playerDetails.getNumero_documento());
		player.get().setTipo_documento(playerDetails.getTipo_documento());
		player.get().setNombre(playerDetails.getNombre());
		player.get().setApellido(playerDetails.getApellido());
		player.get().setEstado(playerDetails.getEstado());
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.save(player.get()));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!playerService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		playerService.deletePlayerById(id);
		return ResponseEntity.ok().build();
	}
	
}
