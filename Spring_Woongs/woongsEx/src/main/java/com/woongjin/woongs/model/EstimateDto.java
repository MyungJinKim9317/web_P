package com.woongjin.woongs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstimateDto {
	private int no;
	private String user_id;
	private String tag;
	private String sub_tag;
	private String title;
	private String description;
	private int budget;
	private String proposal;
	private String content;
	private String name;
	private String sub_name;
	private String image;
	private String work_time;
	private long d_day;
}
