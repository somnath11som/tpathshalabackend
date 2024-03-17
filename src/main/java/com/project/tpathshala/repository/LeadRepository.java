package com.project.tpathshala.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.tpathshala.model.Lead;

import jakarta.transaction.Transactional;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

	@Modifying
    @Transactional
    @Query(value = "UPDATE leads SET assign_user_id = :user_id, assign_by = :asign_by, assign_on = :asign_on WHERE lead_id = :id", nativeQuery = true)
    void asignLead(@Param("id") int id, @Param("user_id") int user_id, @Param("asign_by") int asign_by, @Param("asign_on") Date asign_on);
	
	
    @Transactional
    @Query(value = "SELECT * FROM leads WHERE assign_user_id != 0",countQuery = "SELECT COUNT(*) FROM leads WHERE assign_user_id = 0", nativeQuery = true)
	Page<Lead> findAsignedLead(Pageable pageable);
	
	
    @Transactional
    @Query(value = "SELECT * FROM leads WHERE assign_user_id = 0",countQuery = "SELECT COUNT(*) FROM leads WHERE assign_user_id != 0", nativeQuery = true)
	Page<Lead> findUnAsignedLead(Pageable pageable);
	
}
