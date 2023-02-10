package com.deb.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deb.rest.webservices.restfulwebservices.user.Post;


public interface PostRepository extends JpaRepository<Post, Integer> {

}
