package com.raihanorium.service;

import com.raihanorium.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;

import java.util.List;

/**
 * Created by Raihan on 7/11/2016.
 */
public abstract class BaseService {
    public List getAll(Class clazz) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            ClassMetadata classMetadata = sessionFactory.getClassMetadata(clazz);
            String entityName = classMetadata.getEntityName();
            List list = session.createQuery("FROM " + entityName).list();

            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Object get(long id, Class clazz) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            return session.get(clazz, id);
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Object create(Object object){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.save(object);
            session.getTransaction().commit();

            return object;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }

        return null;
    }

    public boolean delete(long id, Class clazz){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Object object = session.get(clazz, id);
            if (object == null) return false;

            session.delete(object);
            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }

        return false;
    }
}
