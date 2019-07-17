package com.sidieu.api.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sidieu.api.agent.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

}
