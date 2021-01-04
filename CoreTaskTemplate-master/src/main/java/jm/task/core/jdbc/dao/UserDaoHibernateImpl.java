package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        openTransactionSession();

        Session session = getSession();

        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users1 (" +
                "id BIGINT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(45)," +
                " lastName VARCHAR(45)," +
                " age TINYINT," +
                " PRIMARY KEY (id))");

        System.out.println("Table is created!");
        closeTransactionSession();
    }

    @Override
    public void dropUsersTable() {
        openTransactionSession();

        Session session = getSession();

        session.createSQLQuery("DROP TABLE IF EXISTS mydbtest.users1")
                .executeUpdate();

        System.out.println("Tables is dropped!");
        closeTransactionSession();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        openTransactionSession();

        Session session = getSession();

        User user = new User(name, lastName, age);
        session.save(user);
        System.out.println("User с именем " + name + " добавлен в таблицу!");

        closeTransactionSession();
    }

    @Override
    public void removeUserById(long id) {
        openTransactionSession();

        Session session = getSession();

        session.createNativeQuery("DELETE FROM  users1 WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();

        closeTransactionSession();
    }

    @Override
    public List<User> getAllUsers() {
        openTransactionSession();

        Session session = getSession();

        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();

        closeTransactionSession();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        openTransactionSession();

        Session session = getSession();

        session.createSQLQuery("DELETE FROM users1")
                .executeUpdate();
        closeTransactionSession();
    }
}
