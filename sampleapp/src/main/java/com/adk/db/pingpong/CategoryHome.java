package com.adk.db.pingpong;
// Generated Dec 5, 2016 3:59:44 PM by Hibernate Tools 4.3.1.Final

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
 * Home object for domain model class Category.
 * @see com.adk.db.pingpong.Category
 * @author Hibernate Tools
 */
public class CategoryHome {

	private static final Log log = LogFactory.getLog(CategoryHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	
	private static CategoryHome instance = null;

	public static CategoryHome getInstance(){
		if(instance == null){
			instance = new CategoryHome();
		}
		return instance;
	}

	private CategoryHome(){}
	
	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
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

	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(java.lang.Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
	
			Category instance = (Category) s.get("com.adk.db.pingpong.Category", id);
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

	public List findByExample(Category instance) {
		log.debug("finding Category instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.pingpong.Category")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public Category findCategory(String categoryName, String gender, String matchType) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(Category.class);
		Criterion catname = Restrictions.eq("categoryName", categoryName);
		cr.add(catname);
		Criterion gen = Restrictions.eq("gender", gender);
		cr.add(gen);
		Criterion match = Restrictions.eq("matchType", matchType);
		cr.add(match);
//		LogicalExpression andExp1 = Restrictions.and(catname, match);
//		cr.add(andExp1);
		
		List list = cr.list();
		Category c = null;
		if(list != null && list.size()>0){
			c = (Category) list.get(0);
		}else{
			throw new IllegalStateException("No Records found for categoryName = "+ categoryName +", gender = "+gender+", matchType= "+matchType);
		}
		tx.commit();
		return c;	
	}

	public List<Category> findAll() {
		String hql = "from Category c";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery(hql);
		List results = query.list();
		tx.commit();
		return results;
	}
	
}
