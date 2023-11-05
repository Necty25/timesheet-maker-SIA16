package org.scrum.domain.project;

public class WorkPack extends Task{
	public Integer work_pack_id;
	public String work_pack_name;
	
//getters and setters
	public Integer getWork_pack_id() {
		return work_pack_id;
	}
	public void setWork_pack_id(Integer work_pack_id) {
		this.work_pack_id = work_pack_id;
	}
	public String getWork_pack_name() {
		return work_pack_name;
	}
	public void setWork_pack_name(String work_pack_name) {
		this.work_pack_name = work_pack_name;
	}
	
//superclass
	public WorkPack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkPack(Integer task_id, String short_id, String task_name, String chargeCode, Integer work_pack_id) {
		super(task_id, short_id, task_name, chargeCode, work_pack_id);
		// TODO Auto-generated constructor stub
	}

//using fields
	public WorkPack(Integer work_pack_id, String work_pack_name) {
		super();
		this.work_pack_id = work_pack_id;
		this.work_pack_name = work_pack_name;
	}
	
	
	
}
