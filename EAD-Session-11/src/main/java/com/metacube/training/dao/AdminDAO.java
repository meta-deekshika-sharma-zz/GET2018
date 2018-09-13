package com.metacube.training.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

/**
 * @author Deekshika Sharma
 * This interface will work as the base of admin access
 * @param <T>
 */
public interface AdminDAO<T> extends EmployeePortalInterface<T>{

	
}
