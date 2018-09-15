package com.metacube.training.service;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface will have base methods for admin implementation 
 * @param <T>
 */
public interface AdminService<T> {

	public int addField(T t);

	public int updateField(T t);

	public int deleteField(String id);

	public List<T> retreive();

	public T getFieldById(String id);
}
