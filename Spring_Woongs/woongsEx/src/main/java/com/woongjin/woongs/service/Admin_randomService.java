package com.woongjin.woongs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.Admin_randomDao;
import com.woongjin.woongs.model.Admin_randomDto;

import lombok.Setter;

@Service
public class Admin_randomService {
	
	@Setter
	@Autowired
	Admin_randomDao ard;
	
	public void admin_randomAdd(Admin_randomDto ardto) {
		ard.admin_randomAdd(ardto);
	}

}
