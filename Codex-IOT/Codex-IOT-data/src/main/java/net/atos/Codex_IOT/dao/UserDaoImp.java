package net.atos.Codex_IOT.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

/**
 * @author a632972
 *
 */
@Transactional
@Repository
public class UserDaoImp implements UserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImp.class); // Apache
																				// logger

	/**
	 * SessionFactory Interface Reference
	 */
	@Autowired
	private SessionFactory sessionfactory;

	/**
	 * UserDaoImp constructor
	 */
	public UserDaoImp() {
		logger.info("in user dao");
	}

	/*
	 * @see net.atos.Codex-IOT.dao.UserDao#validateUser(net.atos.
	 * Codex-IOT.pojo.User)
	 */
	@Override
	public User validateUser(User user) {
		logger.info("This is User Dao Impl");
		return (User) sessionfactory.getCurrentSession()
				.createQuery("select b from User b where b.username= :username and b.password= :password")
				.setParameter("username", user.getUsername()).setParameter("password", user.getPassword()).uniqueResult();

	}

	@Override
	public User getUserById(long id) {
		logger.info("This is User Dao Impl");
		return (User) sessionfactory.getCurrentSession()
				.get(User.class, id);

	}
	
	
	@Override
	public User addUser(User user) {
		logger.info("in add user dao impl");
		if(sessionfactory.getCurrentSession().save(user)!=null)
			return user;
		return null;
		
	}

	@Override
	public User getUserbyId(long userId) {
		logger.info("in add user dao impl");
		return (User) sessionfactory.getCurrentSession().createQuery("SELECT u FROM User u where u.userId= :userId").setParameter("userId", userId).uniqueResult();
	}

	@Override
	public boolean deleteUsrbyId(User user) {
		sessionfactory.getCurrentSession().delete(user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getusersData() {
		logger.info("in get all user data dao impl");
		return sessionfactory.getCurrentSession().createQuery("SELECT u FROM User u").list();
	}

	@Override
	public void updateuser(User user) {
		logger.info("in add user dao impl");
		sessionfactory.getCurrentSession().saveOrUpdate(user);
		
	}

	@Override
	public boolean saveDeviceIdForSpecificUser(User dummyUser) {
		sessionfactory.getCurrentSession().saveOrUpdate(dummyUser);
		 return true;
	}

	@Override
	public Role getRolebyid(long roleId) {
		return (Role) sessionfactory.getCurrentSession().createQuery("SELECT u FROM Role u where u.roleId= :roleId").setParameter("roleId", roleId).uniqueResult();
		
		//sessionfactory.getCurrentSession().createQuery("SELECT u FROM User u where u.roleId= 2 and u.customerId =:customer_id")
		//sessionfactory.getCurrentSession().createQuery("SELECT u FROM Prject u where u.userid =  ")
		
	}
	
}
