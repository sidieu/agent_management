package com.sidieu.api.agent.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sidieu.api.agent.model.Service;
import com.sidieu.api.agent.repository.ServiceRepository;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService extends CRUDService {

	
	@Autowired
	private ServiceRepository repo;
	
	public List<Service> listService(){
		return repo.findAll();
	}
	
	public Service getService(String id) {
		return repo.findById(id).get();
	}
	
	public boolean ixExiste(String id) {
		return repo.existsById(id);
	}
	
}
