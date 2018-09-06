package com.metacube.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A app config class use to create objects as per requirement
 * @author Deekshika Sharma
 *
 */
@Configuration
public class AppConfig {

	CollectionInjection collectionInjection = new CollectionInjection();

	@Bean
	public CollectionInjection getAllUserList() {
		List<String> userList = new ArrayList<>();

		userList.add("Deekshika");
		userList.add("Arpita");
		userList.add("Prakalpa");
		userList.add("Bhavika");
		userList.add("Rachna");

		collectionInjection.setUserList(userList);
		return collectionInjection;
	}

	@Bean
	public CollectionInjection getAllUserSet() {
		Set<String> userSet = new HashSet<>();

		userSet.add("Deekshika");
		userSet.add("Arpita");
		userSet.add("Prakalpa");
		userSet.add("Bhavika");
		userSet.add("Rachna");

		collectionInjection.setUserSet(userSet);
		return collectionInjection;
	}

	@Bean
	public CollectionInjection getAllUserMap() {
		Map<Integer, String> userMap = new HashMap<Integer, String>();

		userMap.put(1, "Deekshika");
		userMap.put(2, "Arpita");
		userMap.put(3, "Prakalpa");
		userMap.put(4, "Bhavika");
		userMap.put(5, "Rachna");

		collectionInjection.setUserMap(userMap);
		return collectionInjection;
	}
}
