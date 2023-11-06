package org.scrum.domain.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppRole {
	private Integer role_id;
	private String role_name;
	private String role_description;
	private List<String> permisions = new ArrayList<>();
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_description() {
		return role_description;
	}
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	public List<String> getPermisions() {
		return permisions;
	}
	public void setPermisions(List<String> permisions) {
		this.permisions = permisions;
	}
	
	@Override
	public String toString() {
		return "AppRole [role_id=" + role_id + ", role_name=" + role_name + ", role_description=" + role_description
				+ ", permisions=" + permisions + "]";
	}
	
	public AppRole(Integer role_id, String role_name, String role_description, List<String> permisions) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_description = role_description;
		this.permisions = permisions;
	}
	@Override
	public int hashCode() {
		return Objects.hash(role_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppRole other = (AppRole) obj;
		return Objects.equals(role_id, other.role_id);
	}
	
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

