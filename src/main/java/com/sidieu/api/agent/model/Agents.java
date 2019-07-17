package com.sidieu.api.agent.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "agents", catalog = "enrollapp")
public class Agents implements CRUD {

	@Id
	private String matricule;
	private String nom;
	private String postnom;
	private String telephone;
	private char sexe;
	private String idservice;
	@Transient
	private Service service;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPostnom() {
		return postnom;
	}

	public void setPostnom(String postnom) {
		this.postnom = postnom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getIdservice() {
		return idservice;
	}

	public void setIdservice(String idservice) {
		this.idservice = idservice;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	

}
