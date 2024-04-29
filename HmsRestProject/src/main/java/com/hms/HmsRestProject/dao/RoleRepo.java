package com.hms.HmsRestProject.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.HmsRestProject.model.Roles;
@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer>{

}
