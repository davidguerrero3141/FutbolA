package com.futbolA.Api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futbolA.Api.Dao.TeamDao;
import com.futbolA.Api.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	public TeamDao teamDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Team> findAll() {
		return teamDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Team> findAll(Pageable pageable) {
		
		return teamDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Team> findById(Long id) {
		
		return teamDao.findById(id);
	}

	@Override
	@Transactional
	public Team save(Team team) {
		
		return teamDao.save(team);
	}

	@Override
	@Transactional
	public void deleteTeamById(Long id) {
		teamDao.deleteById(id);
		
	}

}
