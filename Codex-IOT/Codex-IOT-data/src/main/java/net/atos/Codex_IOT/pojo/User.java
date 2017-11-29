package net.atos.Codex_IOT.pojo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users",schema = "operationdb")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long userId;

	private String firstname;

	private String lastname;

	private String password;

	private String username;
	
	private String deviceToken;
	
	

	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name="customer_id")
	private Customer customer;
	

	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public User() {
		super();
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * @return the deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	

}