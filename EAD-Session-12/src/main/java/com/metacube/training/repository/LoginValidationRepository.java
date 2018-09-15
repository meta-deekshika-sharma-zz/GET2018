package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.metacube.training.model.Employee;

public interface LoginValidationRepository extends Repository<Employee, Integer>{
}
