package com.test.springjpatest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.springjpatest.entity.User;

public interface UserDao extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{

	public List<User> findByName(String name);
	/**
	 * name 需要 %name%
	 * @param name
	 * @return
	 */
	public List<User> findByNameLike(String name);
	@Transactional
	Page<User> findByName(String name,Pageable pageable);
	/**
	 * 动态查询
	 */
	List<User> findAll(Specification<User> spec);
	
	
}
