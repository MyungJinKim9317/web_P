package com.woongjin.woongs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.QuoteDao;
import com.woongjin.woongs.model.QuoteDto;

import lombok.Setter;

@Service
public class QuoteService {

	@Setter
	@Autowired
	QuoteDao qd;
	
	public void quoteAdd(QuoteDto qdto){
		 qd.quoteAdd(qdto);
	}
	
	public List<QuoteDto> quoteAllSelect() {
		return qd.quoteAllSelect();
	}
	
	public List<EstimateDto> estimateAllSelect(){
		return qd.estimateAllSelect();
	}
	
	public List<QuoteDto> quotePostnoCount(int post_no) {
		return qd.quotePostnoCount(post_no);
	}
	 
	public List<QuoteDto> quotePostAllCount(){
		return qd.quotePostAllCount();
	}
}
