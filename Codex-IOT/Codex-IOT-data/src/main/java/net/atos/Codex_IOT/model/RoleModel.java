package net.atos.Codex_IOT.model;

import java.io.Serializable;


public class RoleModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private long roleId;

	private String rolename;

	private String roletype;


	public RoleModel() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoletype() {
		return this.roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

}