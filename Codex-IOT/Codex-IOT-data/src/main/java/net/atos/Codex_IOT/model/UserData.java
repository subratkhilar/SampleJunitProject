package net.atos.Codex_IOT.model;


import org.apache.log4j.Logger;

public class UserData {
	//Apache logger

	private static final Logger logger = Logger.getLogger(UserData.class); 
	
	private String firstname;

	private String lastname;

	private String password;

	private String username;
		
	private RoleModel roleModel;
	
	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}

	private long userId;
	
	/**
	 * 
	 */
	public UserData()
	{
		logger.info("inside User data");
	}
	

	/**
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}




	/**
	 * @return the roleModel
	 */
	public RoleModel getRoleModel() {
		return roleModel;
	}


	/**
	 * @param roleModel the roleModel to set
	 */
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}


	@Override
	public String toString() {
		return "UserData [ firstname=" + firstname
				+ ", lastname=" + lastname + ", password=" + password
				+ ", username=" + username + ", roleId=" + roleModel + "]";
	}


	
}
