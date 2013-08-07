package com.czy.myclass.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.czy.myclass.dao.UserDao;

@Service
public class BaseServiceImpl {

	@Resource
	protected UserDao userDao;
}
