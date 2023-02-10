package com.deb.rest.webservices.restfulwebservices.user;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deb.rest.webservices.restfulwebservices.repository.PostRepository;
import com.deb.rest.webservices.restfulwebservices.repository.UserRepository;

import jakarta.validation.Valid;



@RestController
public class UserResourceUsingRepository {
	
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/repo/users")
	public List<User> retriveAllUsers(){
		return repository.findAll();
	}
	
	/*@GetMapping("/users/{id}")
	public List<User> retriveUser(@PathVariable Integer id){
		return service.findOneUser(id);
	}*/
	
	@GetMapping("/repo/users/{id}")
	public User retriveOneUser(@PathVariable Integer id){
		User user=  service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id : "+id);
		return user;
	}
	
	@PostMapping("/repo/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
	User savedUser=	repository.save(user);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			buildAndExpand(savedUser.getId()).toUri();
	return	ResponseEntity.created(location ).build();
		
	}
	
	@DeleteMapping("/repo/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		 repository.deleteById(id);
		
	}
	@GetMapping("/repo/users/{id}/post")
	public List<Post> retrivePostForUser(@PathVariable Integer id){
		Optional<User> user =  repository.findById(id);
		 if(user.isEmpty())
			 throw new UserNotFoundException("id : "+id);
		 
		 return user.get().getPost();
	
	}
	@PostMapping("/repo/users/{id}/post")
	public ResponseEntity<Object> createPostForUser(@Valid @RequestBody Post post, @PathVariable Integer id){
		Optional<User> user =  repository.findById(id);
		 if(user.isEmpty())
			 throw new UserNotFoundException("id : "+id);
		 
		 post.setUser(user.get());
		 
		 Post savedPost= postRepository.save(post);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(savedPost.getId()).toUri();
			return	ResponseEntity.created(location ).build();
	
	}
	

}
