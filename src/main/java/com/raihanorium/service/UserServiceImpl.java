package com.raihanorium.service;

import com.raihanorium.model.User;
import com.raihanorium.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Raihan on 7/11/2016.
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            List users = session.createQuery("FROM User").list();

            return users;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public User get(long id) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            User user = (User) session.get(User.class, id);

            return user;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public User create(String userName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            User user = new User();
            user.setName(userName);
            session.save(user);
            session.getTransaction().commit();

            return user;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }

        return null;
    }

    @Override
    public boolean delete(long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            User user = (User) session.get(User.class, id);
            if (user == null) return false;

            session.delete(user);
            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }

        return false;
    }
}
