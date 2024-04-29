package com.hms.HmsRestProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.DiseaseCategory;
import com.hms.HmsRestProject.model.Master;
import com.hms.HmsRestProject.model.Roles;

@Repository
public interface AdminRepo extends JpaRepository<Master, String>{

	@Query("SELECT m FROM Master m WHERE m.role.roleId = 1")
	public List<Master> getAllPhysician();

	
	@Query("SELECT m FROM Master m WHERE m.role.roleId = 2 " )
	public List<Master> getAllNurse();

	
	
}
