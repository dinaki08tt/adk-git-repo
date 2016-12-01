package com.adk.db.pingpong;
// Generated Dec 1, 2016 12:08:39 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.adk.db.util.SessionFactoryHelper;

/**
 * Home object for domain model class PlayerDetails.
 * @see com.adk.db.pingpong.PlayerDetails
 * @author Hibernate Tools
 */
public class PlayerDetailsHome {

	private static final Log log = LogFactory.getLog(PlayerDetailsHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PlayerDetails transientInstance) {
		log.debug("persisting PlayerDetails instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayerDetails instance) {
		log.debug("attaching dirty PlayerDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayerDetails instance) {
		log.debug("attaching clean PlayerDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlayerDetails persistentInstance) {
		log.debug("deleting PlayerDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayerDetails merge(PlayerDetails detachedInstance) {
		log.debug("merging PlayerDetails instance");
		try {
			PlayerDetails result = (PlayerDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlayerDetails findById(java.lang.Integer id) {
		log.debug("getting PlayerDetails instance with id: " + id);
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			PlayerDetails instance = (PlayerDetails) s.get("com.adk.db.pingpong.PlayerDetails", id);

			tx.commit();
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

	public List findByExample(PlayerDetails instance) {
		log.debug("finding PlayerDetails instance by example");
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			List results = s.createCriteria("com.adk.db.pingpong.PlayerDetails")
					.add(Example.create(instance)).list();
			tx.commit();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
