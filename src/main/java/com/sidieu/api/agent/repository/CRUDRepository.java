package com.sidieu.api.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidieu.api.agent.model.Agents;
import com.sidieu.api.agent.model.CRUD;

@Repository
public interface CRUDRepository extends JpaRepository<CRUD, String> {

}
