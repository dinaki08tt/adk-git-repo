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

import com.adk.db.util.SessionFactoryHelper;

/**
 * Home object for domain model class Authorities.
 * @see com.adk.db.pingpong.Authorities
 * @author Hibernate Tools
 */
public class AuthoritiesHome {

	private static final Log log = LogFactory.getLog(AuthoritiesHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	
	
	private static AuthoritiesHome instance = null;

	public static AuthoritiesHome getInstance(){
		if(instance == null){
			instance = new AuthoritiesHome();
		}
		return instance;
	}

	private AuthoritiesHome(){}


	public void persist(Authorities transientInstance) {
		log.debug("persisting Authorities instance");
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

	public void attachDirty(Authorities instance) {
		log.debug("attaching dirty Authorities instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Authorities instance) {
		log.debug("attaching clean Authorities instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Authorities persistentInstance) {
		log.debug("deleting Authorities instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Authorities merge(Authorities detachedInstance) {
		log.debug("merging Authorities instance");
		try {
			Authorities result = (Authorities) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Authorities findById(com.adk.db.pingpong.AuthoritiesId id) {
		log.debug("getting Authorities instance with id: " + id);
		try {
			Authorities instance = (Authorities) sessionFactory.getCurrentSession()
					.get("com.adk.db.pingpong.Authorities", id);
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

	public List findByExample(Authorities instance) {
		log.debug("finding Authorities instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.Authorities")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	

	public void loadInitialRoles(){
		AuthoritiesHome adao = AuthoritiesHome.getInstance();
		Authorities a = new Authorities();
		AuthoritiesId id = new AuthoritiesId();
		id.setAuthority("ROLE_USER");
		id.setUsername("prii_user");
		a.setId(id);
		adao.persist(a);
		a = new Authorities();
		id = new AuthoritiesId();
		id.setAuthority("ROLE_ADMIN");
		id.setUsername("prii_admin");
		a.setId(id);
		adao.persist(a);
	}
}
