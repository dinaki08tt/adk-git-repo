package com.adk.db.pingpong;
// Generated Dec 5, 2016 11:55:24 AM by Hibernate Tools 4.3.1.Final

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
 * Home object for domain model class Tournament.
 * @see com.adk.db.pingpong.Tournament
 * @author Hibernate Tools
 */
public class TournamentHome {

	private static final Log log = LogFactory.getLog(TournamentHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tournament transientInstance) {
		log.debug("persisting Tournament instance");
		try {
			
			Session s =sessionFactory.getCurrentSession();
			Transaction tx= s.beginTransaction();
			s.persist(transientInstance);
			log.debug("persist successful");
			tx.commit();
			
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tournament instance) {
		log.debug("attaching dirty Tournament instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tournament instance) {
		log.debug("attaching clean Tournament instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tournament persistentInstance) {
		log.debug("deleting Tournament instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tournament merge(Tournament detachedInstance) {
		log.debug("merging Tournament instance");
		try {
			Tournament result = (Tournament) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tournament findById(java.lang.Integer id) {
		log.debug("getting Tournament instance with id: " + id);
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			Tournament instance = (Tournament) s.get("com.adk.db.pingpong.Tournament",
					id);
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

	public List findByExample(Tournament instance) {
		log.debug("finding Tournament instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.Tournament")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Tournament findTourByName(String name) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(Tournament.class);
		cr.add(Restrictions.like("tourName", name+"%"));
		List list = cr.list();
		Tournament t = null;
		if(list != null && list.size()>0){
			t = (Tournament) list.get(0);
		}else{
			throw new IllegalStateException("No Records found for Tournament Name = "+ name);
		}
		tx.commit();
		return t;
	}
}
