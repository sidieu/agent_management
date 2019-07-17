package com.sidieu.api.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidieu.api.agent.model.Agents;

@Repository
public interface AgentsRepository extends JpaRepository<Agents, String> {

}
