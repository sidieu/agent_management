package com.sidieu.api.agent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidieu.api.agent.model.CRUD;
import com.sidieu.api.agent.repository.CRUDRepository;

@Service
public class CRUDService {

	@Autowired
	protected CRUDRepository repo;
	
	
	public void saveOrupdate(CRUD crud) {
		repo.save(crud);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
