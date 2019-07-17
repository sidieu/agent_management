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

import com.sidieu.api.agent.model.Service;
import com.sidieu.api.agent.services.ServiceService;
import com.sidieu.api.agent.services.ServiceService;

@RestController
@RequestMapping("/api/service/")
public class ServiceController {
	@Autowired
	private ServiceService serv;

	@GetMapping
	private ResponseEntity<?> listService() {
		List<Service> list = serv.listService();
		if (list.size() == 0) {
			return new ResponseEntity<List<Service>>(list, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Service>>(list, HttpStatus.OK);
		}
	}

	@GetMapping(value = "get-one-by-id")
	private ResponseEntity<?> getService(@RequestParam("id") String id) {
		Service ag = serv.getService(id);
		if (ag.getId().isEmpty()) {
			return new ResponseEntity<Service>(ag, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Service>(ag, HttpStatus.OK);
		}
	}

	@PostMapping
	private ResponseEntity<?> enregistrer(@RequestBody Service Service, UriComponentsBuilder build) {
		if (serv.ixExiste(Service.getId())) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			serv.saveOrupdate(Service);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping
	private ResponseEntity<?> modifier(@RequestBody Service Service) {
		if (serv.ixExiste(Service.getId())) {
			serv.saveOrupdate(Service);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping
	private ResponseEntity<?> supprimer(@RequestBody Service Service) {
		if (serv.ixExiste(Service.getId())) {
			serv.delete(Service.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
