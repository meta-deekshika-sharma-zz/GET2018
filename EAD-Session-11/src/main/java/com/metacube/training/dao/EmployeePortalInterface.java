package com.metacube.training.dao;

import java.util.List;

public interface EmployeePortalInterface<T> {

	public int createField(T t);

	public int updateField(T t);

	public int deleteField(String id);

	public List<T> getField();

	public T getFieldById(String id);
}
