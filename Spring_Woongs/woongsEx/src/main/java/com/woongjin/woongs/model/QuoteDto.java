package com.woongjin.woongs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteDto {

	private int no;
	private String user_id;
	private String worker_id;
	private int post_no;
	private String detail;
	private int estimate_price;
	private int final_price;
	private String attachment;
	private int count;
	
}
