package com.metacube.training;

import java.util.*;

/**
 * @author Deekshika Sharma 
 * This class will have collection using through spring framwork
 */
public class CollectionInjection {

	List userList;
	Set userSet;
	Map userMap;

	/**
	 * There are getter setters are present for each type of collection
	 * 
	 * @return
	 */
	public List getUserList() {
		System.out.println("List element : " + userList);
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public Set getUserSet() {
		System.out.println("Set element :  " + userSet);
		return userSet;
	}

	public void setUserSet(Set userSet) {
		this.userSet = userSet;
	}

	public Map getUserMap() {
		System.out.println("Map element : " + userMap);
		return userMap;
	}

	public void setUserMap(Map userMap) {
		this.userMap = userMap;
	}

}
