package com.adk.db.pingpong;
// Generated Dec 1, 2016 12:08:39 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.adk.db.util.SessionFactoryHelper;

/**
 * Home object for domain model class PlayerScoreDetails.
 * @see com.adk.db.pingpong.PlayerScoreDetails
 * @author Hibernate Tools
 */
public class PlayerScoreDetailsHome {

	private static final Log log = LogFactory.getLog(PlayerScoreDetailsHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PlayerScoreDetails transientInstance) {
		log.debug("persisting PlayerScoreDetails instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayerScoreDetails instance) {
		log.debug("attaching dirty PlayerScoreDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayerScoreDetails instance) {
		log.debug("attaching clean PlayerScoreDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlayerScoreDetails persistentInstance) {
		log.debug("deleting PlayerScoreDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayerScoreDetails merge(PlayerScoreDetails detachedInstance) {
		log.debug("merging PlayerScoreDetails instance");
		try {
			PlayerScoreDetails result = (PlayerScoreDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlayerScoreDetails findById(java.lang.Integer id) {
		log.debug("getting PlayerScoreDetails instance with id: " + id);
		try {
			PlayerScoreDetails instance = (PlayerScoreDetails) sessionFactory.getCurrentSession()
					.get("com.adk.db.pingpong.PlayerScoreDetails", id);
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

	public List findByExample(PlayerScoreDetails instance) {
		log.debug("finding PlayerScoreDetails instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.PlayerScoreDetails")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
