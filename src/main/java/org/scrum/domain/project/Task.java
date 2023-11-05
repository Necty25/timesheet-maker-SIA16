package org.scrum.domain.project;

public class Task {
	
	public Integer task_id; //PK
	public String short_id;
	public String task_name;
	public String chargeCode; //FK
	private Integer work_pack_id; //FK 
	
//getters and setters
	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public String getShort_id() {
		return short_id;
	}
	public void setShort_id(String short_id) {
		this.short_id = short_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public Integer getWork_pack_id() {
		return work_pack_id;
	}
	public void setWork_pack_id(Integer work_pack_id) {
		this.work_pack_id = work_pack_id;
	}
	
//superclass
	public Task() {
		super();
	}
	
//using fields
public Task(Integer task_id, String short_id, String task_name, String chargeCode, Integer work_pack_id) {
	super();
	this.task_id = task_id;
	this.short_id = short_id;
	this.task_name = task_name;
	this.chargeCode = chargeCode;
	this.work_pack_id = work_pack_id;
	}
}


