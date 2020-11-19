package com.woongjin.woongs.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.woongjin.woongs.model.Admin_randomDto;
import com.woongjin.woongs.service.Admin_randomService;


@Controller
public class Admin_randomController {
	
	@Autowired
	Admin_randomService ars;
	
	@RequestMapping("randomAdd")
	public String form() {
		return "random/randomAdd";
	}
	
	@RequestMapping(value = "insertRandomPost", method = RequestMethod.POST)
	public String admin_randomAddPost(Admin_randomDto ardto,MultipartFile report) {
		String path = "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\random";
		String alterpath = "resources\\random\\";

		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
			System.out.println("directory created");
			System.out.println(file.toString());
		} else {
			System.out.println("already exist");
			System.out.println(file.toString());
		}

		path += "\\" + report.getOriginalFilename();
		alterpath += report.getOriginalFilename();

		file = new File(path);

		try {
			report.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ardto.setRandom_post(alterpath);
		ars.admin_randomAdd(ardto);
		
		System.out.println(ardto.getRandom_post());
		System.out.println(ardto.getNo());

		return "redirect:/index.jsp";

	}
}
