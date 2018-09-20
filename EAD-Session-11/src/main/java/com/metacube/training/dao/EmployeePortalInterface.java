package com.metacube.training.dao;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface will be a generic interface applied in employee portal
 * @param <T>
 */
public interface EmployeePortalInterface<T> {

	public int createField(T t);

	public int updateField(T t);

	public int deleteField(String id);

	public List<T> getField();

	public T getFieldById(String id);
}
