package com.woongjin.woongs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.QuoteDto;
import com.woongjin.woongs.model.Sub_TagDto;
import com.woongjin.woongs.model.TagDto;
import com.woongjin.woongs.service.EstimateService;
import com.woongjin.woongs.service.QuoteService;
import com.woongjin.woongs.service.TagService;

@Controller
public class EstimateController {

	@Autowired
	EstimateService es;
	@Autowired
	TagService ts;
	@Autowired
	TagService ws;
	@Autowired
	QuoteService qs;

	@RequestMapping("smartEditor")
	public String form() {
		return "mypage/smartEditorForm";
	}

	@RequestMapping(value = "estimateInsert", method = RequestMethod.POST)
	public String estimateAdd(EstimateDto edto, MultipartFile report) {
		String path = "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\proposal";
		String alterpath = "resources\\proposal\\";

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
		edto.setProposal(alterpath);

		es.estimateAdd(edto);
		System.out.println(edto.getWork_time());
		System.out.println(edto.getContent());
		System.out.println(edto.getProposal());

		return "redirect:/index.jsp";
	}

	@RequestMapping("estimateTagPost")
	public String selectestimateTagPost(Model m) {
		List<TagDto> list = ws.selectTag();
		m.addAttribute("list", list);
		return "mypage/estimateTagPost";
	}

	@RequestMapping("estimatePost")
	public String estimatePost(int no, Model m) {
		List<TagDto> list = ts.selectTagChoose(no);
		m.addAttribute("list", list);
		m.addAttribute("no", no);
		return "mypage/selectPost";
	}

	public static List<Sub_TagDto> listToList(List<Sub_TagDto> fromList, List<Sub_TagDto> toList) {
		for (int i = 0; i < fromList.size(); i++) {
			toList.add(fromList.get(i));
		}

		return toList;
	}

	@RequestMapping(value = "subAjax_p", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String subselect1(int[] subTag) throws Exception {
		System.out.println("test");

		List<Sub_TagDto> sub_list = new ArrayList<Sub_TagDto>();

		for (int i = 0; i < subTag.length; i++) {
			listToList(ws.selectSubTag(subTag[i]), sub_list);
		}

		Gson json = new Gson();
		System.out.println("json.toJson(sub_list)" + json.toJson(sub_list));
		return json.toJson(sub_list);
	}

	// �� function controller ���� �ȸ���

	@RequestMapping("selectSeletEditor")
	public String post(Model m) {
		List<EstimateDto> list = es.estimatePost();

		for (EstimateDto edto : list) {
			System.out.println(edto);

			System.out.println("�޼��� Ȯ�� test");
			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(edto.getWork_time());

			String date1 = sdf.format(date);
			String date2 = edto.getWork_time().toString();

			try { // String Type�� Date Type���� ĳ�����ϸ鼭 ����� ���ܷ� ���� ���⼭ ����ó�� ������ ������ �����Ϸ����� ������ �߻��ؼ�
					// �������� �� �� ����.
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				// date1, date2 �� ��¥�� parse()�� ���� Date������ ��ȯ.
				Date FirstDate = format.parse(date1);
				Date SecondDate = format.parse(date2);

				// Date�� ��ȯ�� �� ��¥�� ����� �� �� ���ϰ����� long type ������ �ʱ�ȭ �ϰ� �ִ�.
				// ������ -950400000. long type ���� return �ȴ�.
				long calDate = FirstDate.getTime() - SecondDate.getTime();

				// Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�.
				// ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
				long calDateDays = calDate / (24 * 60 * 60 * 1000);

				calDateDays = Math.abs(calDateDays);

				System.out.println("�� ��¥�� ��¥ ����: " + calDateDays);
				edto.setD_day(calDateDays);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * �̹��� ������ ������ for(int i=0; i<list.size(); i++) {
		 * list.get(i).setThumbnail(list.get(i).getThumbnail().replace("\\", "/")); }
		 */
		m.addAttribute("list", list);
		/* m.addAttribute("no", list.get(0).getNo()); */
		/* int post_no = list.get(0).getNo(); */
		
		/* List<QuoteDto> list_q = qs.quotePostnoCount(post_no); */
		
		/*
		 * m.addAttribute("post_no", list_q.get(0).getPost_no());
		 * m.addAttribute("count", list_q.get(0).getCount());
		 * 
		 */
		
		List<QuoteDto> list_q = qs.quotePostAllCount();
		m.addAttribute("list_q", list_q);
		
		return "mypage/smartEditorSelect";
	}

	@RequestMapping(value = "smartEditorPost", method = RequestMethod.GET)
	public String postList(Model m, int no) {
		List<EstimateDto> list = es.estimateSelect(no);
		m.addAttribute("list", list);
		m.addAttribute("no", list.get(0).getNo());

		int post_no = list.get(0).getNo();
		List<QuoteDto> list_q = qs.quotePostnoCount(post_no);
		System.out.println("ī���Ͱ��� ������ �ñ� ?" + post_no + " and " + list_q.get(0).getPost_no());
		m.addAttribute("count", list_q.get(0).getCount());
		return "mypage/smartEditorPost";
	}

	@SuppressWarnings("unused")
	@RequestMapping("fileDown")
	public void downloadFile(HttpServletResponse respones, int no) throws Exception {
		List<EstimateDto> list = es.estimateSelect(no);

		// �����ϼ��ؾ���
	}

	@RequestMapping(value = "estimateupdate", method = RequestMethod.POST)
	public String update(int no, Model m) {
		/* System.out.println("��ȣ����"+no); */
		List<EstimateDto> list = es.estimateSelect(no);

		m.addAttribute("list", list);
		System.out.println("list���" + list.toString());
		
		m.addAttribute("tag", list.get(0).getTag());
		m.addAttribute("subTag", list.get(0).getSub_tag());

		return "mypage/smartEditorUpdate";
	}

	@RequestMapping(value = "ajax_c", method = RequestMethod.POST)
	public void tagList_c(HttpServletResponse resp) throws Exception {
		List<TagDto> list = ts.selectTag();

		Gson json = new Gson();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	@RequestMapping(value = "subAjax_c", method = RequestMethod.POST)
	public void subtagList_c(int tag, HttpServletResponse resp) throws Exception {
		System.out.println("subTagsubTagsubTagsubTagsubTag");
		List<Sub_TagDto> list = ts.selectSubTag(tag);

		Gson json = new Gson();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	@RequestMapping(value = "update_end", method = RequestMethod.POST)
	public String estimateUpdate(EstimateDto edto, MultipartFile report) {

		String path = "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\proposal";
		String alterpath = "resources\\proposal\\";

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

		edto.setProposal(alterpath);

		es.estimateUpdate(edto);

		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(int no) {
		es.estimateDelete(no);

		return "redirect:/index.jsp";
	}

}
