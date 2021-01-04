package jm.task.core.jdbc;


import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Util.buildSessionFactory();

        UserDaoHibernateImpl userDaoJDBC = new UserDaoHibernateImpl();
        //userDaoJDBC.createUsersTable();
        //userDaoJDBC.saveUser("Stanislav", "Pan", (byte) 22);
        //userDaoJDBC.removeUserById(1L);
        //userDaoJDBC.saveUser("Andrey", "Kovalev", (byte) 23);
        //userDaoJDBC.saveUser("Gleb", "Zanozin", (byte) 25);
        //userDaoJDBC.saveUser("Oleg", "Kim", (byte) 28);
        userDaoJDBC.saveUser("Gleb", "Zanozin", (byte) 25);
        //System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.saveUser("Gleb", "Zanozin", (byte) 25);


        Util.shutdown();


    }

}
