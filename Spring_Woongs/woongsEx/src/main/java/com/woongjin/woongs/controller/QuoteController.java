package com.woongjin.woongs.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.QuoteDto;
import com.woongjin.woongs.service.QuoteService;

@Controller
public class QuoteController {
	@Autowired
	QuoteService qs;

	@RequestMapping(value = "auoteInsert", method = RequestMethod.POST)
	public String quoteupdate(QuoteDto qdto,MultipartFile report) {
	    
	    String path = "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\attachment";
		String alterpath = "resources\\attachment\\";

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
		
		qdto.setAttachment(alterpath);
		System.out.println(qdto.getFinal_price());
		System.out.println(qdto.getDetail());
		System.out.println(qdto.getAttachment());
		System.out.println(qdto.getNo());
		qs.quoteAdd(qdto); 
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("checkQuote")
	public String checkQuote(Model m){
		List<EstimateDto> list = qs.estimateAllSelect();
		m.addAttribute("post_no", list.get(0).getNo());
		return "quote/quoteForm";
	}
}
