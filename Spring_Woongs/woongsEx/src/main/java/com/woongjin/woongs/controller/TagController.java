package com.woongjin.woongs.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.Sub_TagDto;
import com.woongjin.woongs.model.TagDto;
import com.woongjin.woongs.service.TagService;

@Controller
public class TagController {

	@Autowired
	TagService ws;

	@RequestMapping("insertTagForm")
	public String form() {
		return "insertTagForm";
	}

	@RequestMapping("TF")
	public String pulsTag(String tag_name) {
		ws.addTag(tag_name);
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "insertSub_TagDto", produces = "text/plain;charset=UTF-8")
	public String form2() {
		return "insertSub_TagDto";
	}

	@RequestMapping(value = "ajax", method = RequestMethod.POST)
	public void tagList(HttpServletResponse resp) throws Exception {
		List<TagDto> list = ws.selectTag();

		Gson json = new Gson();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	@RequestMapping("SF")
	public String pulsSubTag(Sub_TagDto dto) {
		ws.addSubTag(dto);
		return "redirect:/index.jsp";
	}

	@RequestMapping("delete")
	public String form3() {
		return "deleteForm";
	}

	@RequestMapping(value = "subAjax", method = RequestMethod.POST)
	public void subtagList(int subTag, HttpServletResponse resp) throws Exception {
		System.out.println("subTagsubTagsubTagsubTagsubTag");
		List<Sub_TagDto> list = ws.selectSubTag(subTag);

		Gson json = new Gson();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	@RequestMapping("De")
	public String deleteTag(TagDto dto) {
		if (dto.getSubno() != 0) {
			ws.deleteSubTag(dto.getSubno());
		} else {
			ws.deleteTag(dto);
		}

		return "redirect:/index.jsp";
	}

	

	
	@RequestMapping(value = "menu")
	public String selectAllTag(Model m){
		List<TagDto> list = ws.selectTag();
		m.addAttribute("list", list);
		return "menu/menu1";
	}
	
	@RequestMapping(value = "allPost", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String orderPost()throws Exception {
		System.out.println("Â¥ÀÜ");
		
		List<PostDto> p_list = ws.orderPost();
		
		for(int i=0; i<p_list.size(); i++) {
			p_list.get(i).setThumbnail(p_list.get(i).getThumbnail().replace("\\", "/"));
		}
		
		Gson json = new Gson();
		System.out.println("json.toJson(p_list)" + json.toJson(p_list));
		return json.toJson(p_list);
	}

	@RequestMapping(value = "subAjax1", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String subselect(int subTag) throws Exception {
		System.out.println("test");
		List<Sub_TagDto> sub_list = ws.selectSubTag(subTag);
		Gson json = new Gson();
		System.out.println("json.toJson(sub_list)" + json.toJson(sub_list));
		return json.toJson(sub_list);
	}

	@RequestMapping(value = "tagPost", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String subPost(int category_first) throws Exception {
		System.out.println("¾Èµµ´Ï");
		List<PostDto> p_list = ws.tagSelectPost(category_first);
		
		for(int i=0; i<p_list.size(); i++) {
			p_list.get(i).setThumbnail(p_list.get(i).getThumbnail().replace("\\", "/"));
		}
		
		Gson json = new Gson();
		System.out.println("json.toJson(p_list)" + json.toJson(p_list));
		return json.toJson(p_list);
	}
	
	@RequestMapping(value = "subMenu1", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String subPost(int category_first, int category_second) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("category_first", category_first);
		map.put("category_second", category_second);

		List<PostDto> p_list = ws.selectAllPost(map);
		
		for(int i=0; i<p_list.size(); i++) {
			p_list.get(i).setThumbnail(p_list.get(i).getThumbnail().replace("\\", "/"));
		}
		
		Gson json = new Gson();
		System.out.println("json.toJson(p_list)" + json.toJson(p_list));
		return json.toJson(p_list);
	}

	@RequestMapping(value="postList",method=RequestMethod.GET)
	public String selectPost(Model m,int no){
	 
	 List<PostDto> list = ws.checkPost(no);
	 m.addAttribute("list", list);
	 
	 for(int i=0; i<list.size(); i++) {
			list.get(i).setThumbnail(list.get(i).getThumbnail().replace("\\", "/"));
		}
		return "menu/postList";
	}
	
	

	
}
