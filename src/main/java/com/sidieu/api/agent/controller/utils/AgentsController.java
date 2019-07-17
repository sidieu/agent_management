package com.sidieu.api.agent.controller.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sidieu.api.agent.model.Agents;
import com.sidieu.api.agent.services.AgentsService;

@RestController
@RequestMapping("/api/agents/")
public class AgentsController {

	@Autowired
	private AgentsService serv;
	
	@GetMapping
	private ResponseEntity<?> listAgents() {
		List<Agents> list = serv.listAgent();
		if (list.size()==0) {
			return new ResponseEntity<List<Agents>>(list,HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Agents>>(list,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="get-one-by-id")
	private ResponseEntity<?> getAgent(@RequestParam("id") String id) {
		Agents ag = serv.getAgent(id);
		if (ag.getMatricule().isEmpty()) {
			return new ResponseEntity<Agents>(ag,HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Agents>(ag,HttpStatus.OK);
		}
	}

	@PostMapping
	private ResponseEntity<?> enregistrer(@RequestBody Agents agents, UriComponentsBuilder build) {
		if (serv.ixExiste(agents.getMatricule())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			serv.saveOrupdate(agents);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping
	private ResponseEntity<?> modifier(@RequestBody Agents agents) {
		if (serv.ixExiste(agents.getMatricule())) {
			serv.saveOrupdate(agents);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping
	private ResponseEntity<?> supprimer(@RequestBody Agents agents) {
		if (serv.ixExiste(agents.getMatricule())) {
			serv.delete(agents.getMatricule());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
