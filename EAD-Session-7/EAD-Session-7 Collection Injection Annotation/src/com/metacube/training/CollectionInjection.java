package com.metacube.training;

import java.util.*;

/**
 * @author Deekshika Sharma 
 * This class will have collection using through spring framwork
 */
public class CollectionInjection {

	List<String> userList;
	Set<String> userSet;
	Map<Integer, String> userMap;

	/**
	 * There are getter setters are present for each type of collection
	 * 
	 * @return
	 */
	public List<String> getUserList() {
		System.out.println("List element : " + userList);
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public Set<String> getUserSet() {
		System.out.println("Set element :  " + userSet);
		return userSet;
	}

	public void setUserSet(Set<String> userSet) {
		this.userSet = userSet;
	}

	public Map<Integer, String> getUserMap() {
		System.out.println("Map element : " + userMap);
		return userMap;
	}

	public void setUserMap(Map<Integer, String> userMap) {
		this.userMap = userMap;
	}

}
