package com.woongjin.woongs.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class QuoteDao extends SqlSessionDaoSupport{

	public void quoteAdd(QuoteDto qdto){
		getSqlSession().insert("quote.quoteAdd",qdto);
	}
	
	public List<QuoteDto> quoteAllSelect() {
		return getSqlSession().selectList("auote.quoteAllSelect");
	}
	
	public List<EstimateDto> estimateAllSelect(){
		return getSqlSession().selectList("quote.estimateAllSelect");
	}
	
	public List<QuoteDto> quotePostnoCount(int post_no) {
		return getSqlSession().selectList("quote.quotePostnoCount",post_no);
	}
	
	public List<QuoteDto> quotePostAllCount(){
		return getSqlSession().selectList("quote.quotePostAllCount");
	}
}
