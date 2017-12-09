package com.test.springjpatest.controller;

import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.springjpatest.Async.TaskAsync;
import com.test.springjpatest.constant.Sex;
import com.test.springjpatest.dao.UserDaoSpec;
import com.test.springjpatest.entity.User;
import com.test.springjpatest.service.IUserService;

@RestController
@RequestMapping("/test")
public class GetDataController {

	@Autowired
	private IUserService userService;
	@Autowired
	private TaskAsync task;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping("getUser")
	public String getUser(
			@RequestParam(value = "id", required = false, defaultValue = "1") Long id) {

		return userService.getById(id).toString();
	}

	@GetMapping("save")
	public String save(@RequestParam("name") String name,
			@RequestParam("sex") Sex sex, @RequestParam("age") Integer age) {
		User user = new User();
		user.setAge(age);
		user.setSex(sex);
		user.setName(name);
		userService.save(user);
		return user.toString();
	}

	@GetMapping("findByName")
	public String findByName(@RequestParam("name") String name) {
		int size = 0;
		List<User> list = userService.findByName(name);
		if (!CollectionUtils.isEmpty(list)) {
			size = list.size();
		}
		return "size:" + size;
	}

	@GetMapping("like")
	public String findByNameLike(@RequestParam("name") String name) {
		int size = 0;
		name = "%" + name + "%";
		List<User> list = userService.findByNameLike(name);
		if (!CollectionUtils.isEmpty(list)) {
			size = list.size();
		}

		return "size:" + size;
	}

	@GetMapping("/page")
	public String findByPage(@RequestParam("name") String name,
			@RequestParam(value = "page") Integer page,
			@RequestParam(value = "rows") Integer size) {
		Pageable pageable = new PageRequest(page - 1, size);
		JSONObject josn = new JSONObject();

		Page<User> pages = userService.findByName(name, pageable);
		List<User> list = pages.getContent();
		JSONArray array = JSONArray.fromObject(list);
		long total = pages.getTotalElements();
		josn.put("data", array);
		josn.put("total", total);
		return josn.toString();
	}

	@GetMapping("dynamic")
	public String dynamic(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value="age" ,required=false,defaultValue="0") int age) {
		JSONObject json = new JSONObject();
		List<User> list = userService.findAll(UserDaoSpec.getSpec(name, age, null));
		JSONArray array = JSONArray.fromObject(list);
		json.put("data", array);
		return json.toString();

	}
	@GetMapping("async")
	public String async(){
		Calendar calendar=Calendar.getInstance();
		long current=calendar.getTimeInMillis();
		for(int i=0;i<100;i++){
			task.task(i, current);
		}
		Calendar calendar1=Calendar.getInstance();
		long current1=calendar1.getTimeInMillis();
		return "ok:"+(current1-current);
	}
	
	

}
