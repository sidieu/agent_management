package com.sidieu.api.agent.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidieu.api.agent.model.Agents;
import com.sidieu.api.agent.repository.AgentsRepository;

@Service
@Transactional
public class AgentsService extends CRUDService {

	@Autowired
	private AgentsRepository repo;
	
	public List<Agents> listAgent(){
		return repo.findAll();
	}
	
	public Agents getAgent(String id) {
		return repo.findById(id).get();
	}
	
	
	public boolean ixExiste(String id) {
		return repo.existsById(id);
	}
	
}
