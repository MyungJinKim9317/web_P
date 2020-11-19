package com.woongjin.woongs.model;

public class PostDto {
	int no;
	String user_id;
	int category_first;
	int category_second;
	String thumbnail;
	String title;
	String description;
	int price;
	int worktime;
	int retouch_count;
	String service_description;
	String requirement;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getCategory_first() {
		return category_first;
	}

	public void setCategory_first(int category_first) {
		this.category_first = category_first;
	}

	public int getCategory_second() {
		return category_second;
	}

	public void setCategory_second(int category_second) {
		this.category_second = category_second;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWorktime() {
		return worktime;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}

	public int getRetouch_count() {
		return retouch_count;
	}

	public void setRetouch_count(int retouch_count) {
		this.retouch_count = retouch_count;
	}

	public String getService_description() {
		return service_description;
	}

	public void setService_description(String service_description) {
		this.service_description = service_description;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

}
