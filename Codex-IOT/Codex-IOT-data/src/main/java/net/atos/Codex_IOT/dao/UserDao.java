package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

/**
 * @author a632972
 *
 */
/**
 * @author a622890
 *
 */
public interface UserDao {

	/**
	 * @param user
	 * @return User credentials
	 */
	User validateUser(User user);
	
	/**
	 * @param id
	 * @return
	 */
	User getUserById(long id);
	
	/**
	 * @param user
	 * @return
	 */
	public User addUser(User user);
	
	/**
	 * @param userId
	 * @return
	 */
	User getUserbyId(long userId);
	
	boolean deleteUsrbyId(User user);
	
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

	Role getRolebyid(long roleId);
}
