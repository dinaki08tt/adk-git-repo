package com.adk.db.pingpong;
// Generated Dec 5, 2016 10:30:32 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

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
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PlayerDetails instance) {
		log.debug("finding PlayerDetails instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.PlayerDetails")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public PlayerDetails findByPlayerCode(String playerCode) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(PlayerDetails.class);
		cr.add(Restrictions.like("playerCode", playerCode+"%"));
		List list = cr.list();
		PlayerDetails p = null;
		if(list != null && list.size()>0){
			p = (PlayerDetails) list.get(0);
		}else{
			throw new IllegalStateException("No Records found for playerCode = "+ playerCode);
		}
		tx.commit();
		return p;
	}
}
