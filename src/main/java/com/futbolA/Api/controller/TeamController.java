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

import com.futbolA.Api.entity.Team;
import com.futbolA.Api.services.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	@Autowired
	public TeamService teamService;
	
	 @GetMapping
	 public List<Team> readAll(){
		 List<Team> teams = StreamSupport
				 .stream(teamService.findAll().spliterator(), false)
				 .collect(Collectors.toList());
		 return teams;
	 }

	@PostMapping
	public ResponseEntity<?> create ( @RequestBody Team team){
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(team));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Team> oTeam = teamService.findById(id);
		if(!oTeam.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.of(oTeam);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Team teamDetails, @PathVariable Long id){
		Optional<Team> team = teamService.findById(id);
		if(!team.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		team.get().setNombre(teamDetails.getNombre());
		team.get().setCodigo(teamDetails.getCodigo());
		team.get().setEstado(teamDetails.getEstado());
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.save(team.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!teamService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		teamService.deleteTeamById(id);
		return ResponseEntity.ok().build();
	}
}
