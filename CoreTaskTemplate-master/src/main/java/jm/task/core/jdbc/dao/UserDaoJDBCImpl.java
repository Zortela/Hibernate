package jm.task.core.jdbc.dao;

import com.mysql.cj.protocol.Resultset;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*public class UserDaoJDBCImpl extends Util implements UserDao {


    public void createUsersTable() throws SQLException {
        Connection connection = getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    " name VARCHAR(45)," +
                    " lastName VARCHAR(45)," +
                    " age TINYINT," +
                    " PRIMARY KEY (id))");

            System.out.println("Table is created!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void dropUsersTable() throws SQLException {
        Connection connection = getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Table is dropped!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO users (name, lastName, age) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User is saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM mydbtest.users WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println("User is Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = getConnection();

        List<User> userList = new ArrayList<>();

        String query = "SELECT * FROM users";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery(query);

            while (resultset.next()) {
                User user = new User();
                user.setId(resultset.getLong("id"));
                user.setName(resultset.getString("name"));
                user.setLastName(resultset.getString("lastName"));
                user.setAge(resultset.getByte("age"));

                userList.add(user);
            }

        } catch (SQLSyntaxErrorException e) {
            System.err.println("Table does not exist!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = getConnection();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute("DELETE FROM mydbtest.users ");
            System.out.println("Tables is cleared!");

        } catch (SQLException e) {
            System.err.println("Table does not exist");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}*/
