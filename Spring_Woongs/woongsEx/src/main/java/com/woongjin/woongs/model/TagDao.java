package com.woongjin.woongs.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TagDao extends SqlSessionDaoSupport{

	public void addTag(String td) {
		 getSqlSession().insert("Tag.addTag",td);
	}
	
	public List<TagDto> selectTag(){
		return getSqlSession().selectList("Tag.chooseTag");
	}
	
	public List<TagDto> selectTagChoose(int no){
		return getSqlSession().selectList("Tag.chooseTag",no);
	}
	
	public void addSubTag(Sub_TagDto dto) {
		getSqlSession().insert("Tag.addSub_Tag",dto);
	}
	
	public void deleteTag(TagDto dto) {
		getSqlSession().delete("Tag.deleteTag",dto);
	}
	
	public void deleteSubTag(int sdto) {
		getSqlSession().delete("Tag.deleteSubTag", sdto);
	}
	
	public List<Sub_TagDto> selectSubTag(int subTag){
		return getSqlSession().selectList("Tag.chooseSubTag",subTag);
	}
	
	
}
