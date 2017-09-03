package com.test.springjpatest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.test.springjpatest.entity.User;

public interface IUserService {

	public int save(User user);
	
	public User getById(Long id);
	
	public List<User> findByName(String name);
	public List<User> findByNameLike(String name);
	
	public Page<User> findByName(String name,Pageable pageable);
	
	List<User> findAll(Specification<User> spec);
	
}
