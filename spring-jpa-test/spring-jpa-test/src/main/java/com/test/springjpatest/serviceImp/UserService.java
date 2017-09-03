package com.test.springjpatest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.test.springjpatest.dao.UserDao;
import com.test.springjpatest.entity.User;
import com.test.springjpatest.service.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int save(User user) {
		userDao.save(user);
		return 0;
	}

	@Override
	public User getById(Long id) {
		
		return userDao.getOne(id);
	}

	@Override
	public List<User> findByName(String name) {
		
		return userDao.findByName(name);
	}

	@Override
	public List<User> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return userDao.findByNameLike(name);
	}

	@Override
	public Page<User> findByName(String name, Pageable pageable) {
		
		return userDao.findByName(name, pageable);
	}

	@Override
	public List<User> findAll(Specification<User> spec) {
		return userDao.findAll(spec);
	}

	
}
