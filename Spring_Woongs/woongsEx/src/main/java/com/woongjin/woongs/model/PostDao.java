package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PostDao extends SqlSessionDaoSupport {

	public List<PostDto> selectPost(Map<String, Integer> map){
		return getSqlSession().selectList("Tag.selectPost",map);
	}
	
	public List<PostDto> tagSelectPost(int post){
		return getSqlSession().selectList("Tag.tagSelectPost",post);
	}
	
	public List<PostDto> checkPost(int post){
		return getSqlSession().selectList("Tag.checkPost", post);
	}
	
	public List<PostDto> orderPost() {
		 return getSqlSession().selectList("Tag.orderPost");
	}
	
}
