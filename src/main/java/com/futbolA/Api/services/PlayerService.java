package com.futbolA.Api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.futbolA.Api.entity.Player;

public interface PlayerService {

	public Iterable<Player> findAll();
	
	public Page<Player> findAll(Pageable pageable);
	
	public Optional<Player> findById(Long id);
	
	public Player save(Player player);
	
	public void deletePlayerById(Long id);
}
