package com.adk.db.pingpong;
// Generated Dec 5, 2016 10:30:32 AM by Hibernate Tools 4.3.1.Final

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
 * Home object for domain model class GameScore.
 * @see com.adk.db.pingpong.GameScore
 * @author Hibernate Tools
 */
public class GameScoreHome {

	private static final Log log = LogFactory.getLog(GameScoreHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	private static GameScoreHome instance = null;

	public static GameScoreHome getInstance(){
		if(instance == null){
			instance = new GameScoreHome();
		}
		return instance;
	}

	private GameScoreHome(){}
	
	public void persist(GameScore transientInstance) {
		log.debug("persisting GameScore instance");
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

	public void attachDirty(GameScore instance) {
		log.debug("attaching dirty GameScore instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GameScore instance) {
		log.debug("attaching clean GameScore instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GameScore persistentInstance) {
		log.debug("deleting GameScore instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GameScore merge(GameScore detachedInstance) {
		log.debug("merging GameScore instance");
		try {
			GameScore result = (GameScore) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GameScore findById(java.lang.Integer id) {
		log.debug("getting GameScore instance with id: " + id);
		try {
			GameScore instance = (GameScore) sessionFactory.getCurrentSession().get("com.adk.db.pingpong.GameScore",
					id);
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

	public List findByExample(GameScore instance) {
		log.debug("finding GameScore instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.GameScore")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
