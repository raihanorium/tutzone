package com.raihanorium.service;

import com.raihanorium.util.HibernateUtil;
import com.raihanorium.util.Page;
import com.raihanorium.util.SortDirection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by Raihan on 7/11/2016.
 */
public abstract class BaseService {
    public Page getAll(Class clazz, Page page) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            page.setOffset((page.getOffset() == null) ? 0 : page.getOffset());
            page.setPageSize((page.getPageSize() == null) ? 0 : page.getPageSize());
            page.setSortColumn((page.getSortColumn() == null) ? "name" : page.getSortColumn());

            List list = session.createCriteria(clazz)
                    .setFirstResult(page.getOffset())
                    .setMaxResults(page.getPageSize())
                    .addOrder(
                            (page.getSortDirection() == SortDirection.ASC) ?
                                    Order.asc(page.getSortColumn()) :
                                    Order.desc(page.getSortColumn()))
                    .list();

            page.setResource(list);
            page.setTotalCount(count(clazz));

            return page;
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

    public Object create(Object object) {
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

    public Object save(Object object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(object);
            session.getTransaction().commit();

            return object;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }

        return null;
    }

    public boolean delete(long id, Class clazz) {
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

    public long count(Class clazz) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long count = 0;

        try {
            count = (long) session.createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }

        return count;
    }
}
