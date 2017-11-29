package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.model.UserData;
import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

/**
 * @author a622890
 *
 */
public interface UserService {
	
	/**
	 * @param user
	 * @return User
	 */
	/**
	 * @param user
	 * @return
	 */
	User getValidateUser(User user);

	/**
	 * @param id
	 * @return
	 */
	User getUserByID(long id);
		
	/**
	 * @param userdata
	 * @return
	 */
	public UserData addUser(UserData userdata);

	/**
	 * @param userId
	 * @return
	 */
	User getUserbyId(long userId);

	/**
	 * @param userId
	 * @return
	 */
	boolean deleteUsrbyId(long userId);

	/**
	 * @return
	 */
	List<User> getusersData();

	/**
	 * @param user
	 */
	public void updateuser(User user);

	/**
	 * @param dummyUser
	 * @return
	 */
	boolean saveDeviceIdForSpecificUser(User dummyUser);
	
	/**
	 * @param roleId
	 * @return
	 */
	Role getRolebyid(long roleId);
	
}