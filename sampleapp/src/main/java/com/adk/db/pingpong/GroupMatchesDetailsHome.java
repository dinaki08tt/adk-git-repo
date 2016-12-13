package com.adk.db.pingpong;
// Generated Dec 5, 2016 10:30:32 AM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.adk.db.util.SessionFactoryHelper;

/**
 * Home object for domain model class GroupMatchesDetails.
 * @see com.adk.db.pingpong.GroupMatchesDetails
 * @author Hibernate Tools
 */
public class GroupMatchesDetailsHome {

	private static final Log log = LogFactory.getLog(GroupMatchesDetailsHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}


	private static GroupMatchesDetailsHome instance = null;

	public static GroupMatchesDetailsHome getInstance(){
		if(instance == null){
			instance = new GroupMatchesDetailsHome();
		}
		return instance;
	}

	private GroupMatchesDetailsHome(){}
	
	
	public void persist(GroupMatchesDetails transientInstance) {
		log.debug("persisting GroupMatchesDetails instance");
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

	public void attachDirty(GroupMatchesDetails instance) {
		log.debug("attaching dirty GroupMatchesDetails instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GroupMatchesDetails instance) {
		log.debug("attaching clean GroupMatchesDetails instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GroupMatchesDetails persistentInstance) {
		log.debug("deleting GroupMatchesDetails instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GroupMatchesDetails merge(GroupMatchesDetails detachedInstance) {
		log.debug("merging GroupMatchesDetails instance");
		try {
			GroupMatchesDetails result = (GroupMatchesDetails) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GroupMatchesDetails findById(java.lang.Integer id) {
		log.debug("getting GroupMatchesDetails instance with id: " + id);
		try {
			//Session s = sessionFactory.getCurrentSession();
			Session s = sessionFactory.openSession();
			
			Transaction tx = s.beginTransaction();
			GroupMatchesDetails instance = (GroupMatchesDetails) s.get("com.adk.db.pingpong.GroupMatchesDetails", id);
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

	public List findByExample(GroupMatchesDetails instance) {
		log.debug("finding GroupMatchesDetails instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.GroupMatchesDetails")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<String> findDistinctGroupNameByEventid(Integer eventId) {
		String hql = "select distinct g.groupName from GroupMatchesDetails g, Event e where e.eventId = "+eventId;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery(hql);
		List results = query.list();
		
		tx.commit();
		return results;
	}
	/**
	 * 
	 * @param groupName
	 * @param eventId
	 * @return
	 */
	public List<GroupMatchesDetails> findGroupsByGroupNameAndEvent(String groupName, Integer eventId) {
		String hql = "select g from GroupMatchesDetails g , Event e where g.groupName = "+groupName+" and e.eventId = "+eventId;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery(hql);
		List results = query.list();
		tx.commit();
		return results;
	}
	
	
	public GroupMatchesDetails findMatchByMatchId(String groupName, Integer matchId) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(GroupMatchesDetails.class);
		Criterion m = Restrictions.eq("groupName", groupName);
		cr.add(m);
		Criterion g = Restrictions.eq("matchId", matchId);
		cr.add(g);
		LogicalExpression andExp = Restrictions.and(m, g);
		cr.add(andExp);
		List list = cr.list();
		GroupMatchesDetails grp = null;
		if(list != null && list.size()>0){
			grp = (GroupMatchesDetails) list.get(0);
		}else{
			throw new IllegalStateException("No Records found for match Id = "+ matchId+"  groupName ="+groupName);
		}
		tx.commit();
		return grp;
	}

	public GroupMatchesDetails update(GroupMatchesDetails match) {
		log.debug("updating GroupMatchesDetails instance");
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(match);
			match = findById(match.getGroupId());
				
			log.debug("persist successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return match;
	}
	
}
