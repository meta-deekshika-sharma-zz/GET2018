package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.LoginValidationRepository;

public class LoginValidationImplementation implements LoginValidation{

	@Autowired
	LoginValidationRepository repository;
	
	@Override
	public boolean isAdminLoginValid(String username, String password) {
		if("admin".equals(username) && "admin".equals(password))
			return true;
		return false;
	}

	@Override
	public boolean isEmployeeLoginValid(String username, String password) {
		return false;
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Employee> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Employee> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveAndFlush(Employee arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Employee> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Employee> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Employee> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
