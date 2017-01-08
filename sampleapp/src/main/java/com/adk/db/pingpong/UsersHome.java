package com.adk.db.pingpong;
// Generated Dec 24, 2016 8:57:27 AM by Hibernate Tools 4.3.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adk.db.util.SessionFactoryHelper;

/**
 * Home object for domain model class Users.
 * @see com.adk.db.pingpong.Users
 * @author Hibernate Tools
 */
public class UsersHome {

	private static final Log log = LogFactory.getLog(UsersHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	
	private static UsersHome instance = null;

	public static UsersHome getInstance(){
		if(instance == null){
			instance = new UsersHome();
		}
		return instance;
	}

	private UsersHome(){}

	
	public void persist(Users transientInstance) {
		log.debug("persisting Users instance");
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.persist(transientInstance);
			log.debug("persist successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) sessionFactory.getCurrentSession().get("com.adk.db.pingpong.Users", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.Users")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void loadInitialUsers(){
		UsersHome udao = UsersHome.getInstance(); 
		Users user = new Users();
		user.setUsername("prii_user");
		user.setPassword(getHashPassword("prii123"));
		user.setEnabled(true);
		udao.persist(user);
		
		user = new Users();
		user.setUsername("prii_admin");
		user.setPassword(getHashPassword("prii123"));
		user.setEnabled(true);
		udao.persist(user);
		
	}

	private String getHashPassword(String string) {
		   PasswordEncoder encoder = new BCryptPasswordEncoder();
	       String hashedPassword = "";
	       hashedPassword = encoder.encode(string);
		
		return hashedPassword;
	}
	
	public boolean isInitialLoaded(){
		UsersHome udao = UsersHome.getInstance();

		Users u = null;
		try{
		u = udao.findByName("prii_user");
		}catch(IllegalStateException e){
			return false;
		}
		
		if(u!=null){
			return true;
		}
		return false;
	}

	public Users findByName(String name) {
		Session s = sessionFactory.openSession(); //sessionFactory.getCurrentSession();
		try{
			Transaction tx = s.beginTransaction();
			Criteria cr = s.createCriteria(Users.class);
			cr.add(Restrictions.eq("username", name));
			List list = cr.list();
			Users t = null;
			if(list != null && list.size()>0){
				t = (Users) list.get(0);
			}else{
				throw new IllegalStateException("No Records found for User Name = "+ name);
			}
			tx.commit();
			return t;
			
		}finally{
//			s.close();
		}
	}
}
