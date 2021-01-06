package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users1 (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(45)," +
                    " lastName VARCHAR(45)," +
                    " age TINYINT," +
                    " PRIMARY KEY (id))");

            System.out.println("Table is created!");

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void dropUsersTable() {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            session.createSQLQuery("DROP TABLE IF EXISTS mydbtest.users1")
                    .executeUpdate();

            System.out.println("Tables is dropped!");

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            User user = new User(name, lastName, age);
            session.save(user);

            System.out.println("User с именем " + name + " добавлен в таблицу!");

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }


    }

    @Override
    public void removeUserById(long id) {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            session.createNativeQuery("DELETE FROM  users1 WHERE id = :id")
                    .setParameter("id", id)
                    .executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            Criteria criteria = session.createCriteria(User.class);
            List<User> userList = criteria.list();

            transaction.commit();

            return userList;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        Util util = new Util();

        Session session = util.openSession();
        Transaction transaction = util.openTransaction();

        try {
            session.createSQLQuery("DELETE FROM users1")
                    .executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

    }
}
