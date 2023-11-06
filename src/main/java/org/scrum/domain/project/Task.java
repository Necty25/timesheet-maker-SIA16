package org.scrum.domain.project;

import java.util.Objects;

public class Task {
	
	private Integer task_id; //PK
	private String short_id;
	private String task_name;
	private String chargeCode; //FK
	
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

	
//using fields
public Task(Integer task_id, String short_id, String task_name, String chargeCode, Integer work_pack_id) {
	super();
	this.task_id = task_id;
	this.short_id = short_id;
	this.task_name = task_name;
	this.chargeCode = chargeCode;
	}


@Override
public int hashCode() {
	return Objects.hash(task_id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Task other = (Task) obj;
	return Objects.equals(task_id, other.task_id);
	}
@Override
public String toString() {
	return "Task [task_id=" + task_id + ", short_id=" + short_id + ", task_name=" + task_name + ", chargeCode="
			+ chargeCode + "]";
	}
}


