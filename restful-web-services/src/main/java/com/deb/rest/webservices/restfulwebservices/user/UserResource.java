package com.deb.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	/*@GetMapping("/users/{id}")
	public List<User> retriveUser(@PathVariable Integer id){
		return service.findOneUser(id);
	}*/
	
	@GetMapping("/users/{id}")
	public User retriveOneUser(@PathVariable Integer id){
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		service.save(user);
		
	}
	

}
