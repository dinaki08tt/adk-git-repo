package com.adk.db;
// Generated Nov 28, 2016 3:47:07 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Home object for domain model class Person.
 * @see com.adk.db.Person
 * @author Hibernate Tools
 */
public class PersonHome {

	private static final Log log = LogFactory.getLog(PersonHome.class);

	private final SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Person transientInstance) {
		log.debug("persisting Person instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Person instance) {
		log.debug("attaching dirty Person instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Person instance) {
		log.debug("attaching clean Person instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Person persistentInstance) {
		log.debug("deleting Person instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Person merge(Person detachedInstance) {
		log.debug("merging Person instance");
		try {
			Person result = (Person) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Person findById(int id) {
		log.debug("getting Person instance with id: " + id);
		try {
			//fetchRecords();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Person instance = (Person) session.get("com.adk.db.Person", id);
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

	public List findByExample(Person instance) {
		log.debug("finding Person instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.adk.db.Person")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void fetchRecords(){
		int i = 0;
		do{
			i++;
			if(i == 0){
				System.out.println("i is 0");
			}
		}while(i<1000000000);
		int j = 0;
		do{
			j++;
			if(j == 0){
				System.out.println("j is 0");
			}
		}while(j<100000000);
		int k = 0;
		do{
			k++;
			if(k == 0){
				System.out.println("k is 0");
			}
		}while(k<100000000);
		int l = 0;
		do{
			l++;
			if(l == 0){
				System.out.println("l is 0");
			}
		}while(l<100000000);
	}
}
