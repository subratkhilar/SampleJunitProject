package net.atos.Codex_IOT.model;

/**
 * @author a622890
 *
 */
public class UserModels {

	private long userId;

	private String firstname;

	private String lastname;

	private String password;

	private String username;
	
	private String deviceToken;
	
	private long roleId;


	private long customerId;




	public long getRoleId() {
		return roleId;
	}


	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDeviceToken() {
		return deviceToken;
	}


	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}


	@Override
	public String toString() {
		return "UserModels [userId=" + userId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", password=" + password
				+ ", username=" + username + ", deviceToken=" + deviceToken
				+ ", roleId=" + roleId 
				+ ", customerId=" + customerId + "]";
	}


	
}
