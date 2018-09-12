package com.metacube.training.dao;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface will work for employee profile 
 * @param <T>
 */
public interface EmployeeProfileDAO<T> {

	public int createField(T t);

	public int updateField(T t);

	public int deleteField(String id);

	public List<T> getField();

	public T getFieldById(String id);
}
