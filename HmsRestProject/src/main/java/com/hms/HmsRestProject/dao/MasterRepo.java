package com.hms.HmsRestProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.Master;

@Repository
public interface MasterRepo extends JpaRepository<Master, String> {

	// Method for authentication
	@Query("SELECT m FROM Master m WHERE m.email = :email AND m.password= :password")
	public Master findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	// Method for password recovery
	public Master findByEmail(String email);

	// Method for changing password
	public boolean existsByEmailAndPassword(String email, String password);

	@Query("SELECT m FROM Master m WHERE m.diseaseCategory.diseaseCategoryName = :category AND m.role.roleName = :roleName")
	public List<Master> getMasterByCategory(@Param("category") String category, @Param("roleName") String roleName);

}
