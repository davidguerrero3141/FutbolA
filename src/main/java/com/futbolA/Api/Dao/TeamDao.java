package com.futbolA.Api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futbolA.Api.entity.Team;

@Repository
public interface TeamDao extends JpaRepository<Team, Long> {

}
