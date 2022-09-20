package com.futbolA.Api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futbolA.Api.entity.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, Long> {

}
