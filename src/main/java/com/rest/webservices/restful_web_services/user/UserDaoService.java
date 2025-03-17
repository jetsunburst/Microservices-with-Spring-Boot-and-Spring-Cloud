package com.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		
		users.add(new User(1, "Akash", LocalDate.now().minusYears(28)));
		users.add(new User(2, "Prakash", LocalDate.now().minusYears(27)));
		users.add(new User(3, "Vikas", LocalDate.now().minusYears(26)));
	}
	
	public List<User> findAll() {
		return users;
	}
	

	public Optional<User> findOne(int id) {
	    Predicate<User> predicate = user -> user.getId().equals(id);
	    return users.stream().filter(predicate).findFirst();
	}
}
