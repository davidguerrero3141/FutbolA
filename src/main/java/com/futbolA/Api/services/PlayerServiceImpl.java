package com.futbolA.Api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbolA.Api.Dao.PlayerDao;
import com.futbolA.Api.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	public PlayerDao playerDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Player> findAll() {
		return playerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Player> findAll(Pageable pageable) {
		return playerDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Player> findById(Long id) {
		
		return playerDao.findById(id);
	}

	@Override
	@Transactional
	public Player save(Player player) {
		return playerDao.save(player);
	}

	@Override
	@Transactional
	public void deletePlayerById(Long id) {
		playerDao.deleteById(id);
		
	}

}
