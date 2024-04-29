package com.hms.HmsRestProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.HmsRestProject.model.BloodPressure;

public interface BloodPressureRepo extends JpaRepository<BloodPressure, String>{

}
