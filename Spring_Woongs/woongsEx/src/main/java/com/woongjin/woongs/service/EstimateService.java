package com.woongjin.woongs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.EstimateDao;
import com.woongjin.woongs.model.EstimateDto;

import lombok.Setter;

@Service
public class EstimateService {

	@Setter
	@Autowired
	EstimateDao ed;
	
	public void estimateAdd(EstimateDto edto){
		ed.estimateAdd(edto);
	}
	
	public List<EstimateDto> estimatePost(){
		return ed.estimatePost();
	}
	
	public List<EstimateDto> estimateSelect(int no){
		return ed.estimateSelect(no);
	}
	
	public void estimateUpdate(EstimateDto edto){
		 ed.estimateUpdate(edto);
	}
	
	public void estimateDelete(int no) {
		 ed.estimateDelete(no);
	}
	
	public List<EstimateDto> orderEstimate(int no) {
		return ed.orderEstimate(no);
	}

}
