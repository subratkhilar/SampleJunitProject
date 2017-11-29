package net.atos.Codex_IOT.pojo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role",schema = "operationdb")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private long roleId;

	private String rolename;

	private String roletype;

	//bi-directional many-to-one association to User
	/*@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;*/

	//bi-directional many-to-one association to User
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<User> users;

	public Role() {
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
	
	/*
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	*/

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

}