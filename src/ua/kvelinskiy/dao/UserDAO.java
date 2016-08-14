package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * The CatalogueDAO class responds for getting and putting information about
 * user in and from database.
 * @author I.K.
 */

public class UserDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    UserDAO(DataSource ds) {
        this.ds = ds;
    }

    public boolean isExist(User user) {
        try ( Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("EXISTS_USER"));
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public boolean isExistLogin(User user) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("EXISTS_LOGIN"));
            ps.setString(1, user.getLogin());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public boolean insertNewUser(User user) {
        int maxNumberAbonnement = getMaxNumberAbonnement() + 1;
        String maximNumberAbonnement = "B-00" + maxNumberAbonnement ;
        boolean exist = isExist(user);
        try (Connection conn = ds.getConnection()) {
           if (!exist) {
                PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("INSERT_USER"));
                ps.setString(1, "FirstName");
                ps.setString(2, "LastName");
                ps.setString(3, maximNumberAbonnement);
                ps.setString(4, "Contact Information");
                ps.setString(5, user.getLogin());
                ps.setString(6, user.getPassword());
                ps.setString(7, "false");
                ps.execute();
           }
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public int getMaxNumberAbonnement(){
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("MAX_NUMBER_ABONNEMENT"));
            ResultSet rs = ps.executeQuery();
            rs.next();
            int maxNumberAbonnement = rs.getInt(1);
            return maxNumberAbonnement;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return 0;
        }
    }

    public User getUserData(User user){
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_USER_DATA"));
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setAbonnement(rs.getString("abonnement"));
                user.setContactInformation(rs.getString("contact_information"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setLibrarian(rs.getBoolean("is_librarian"));
            }
            return user;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }

    public boolean updateUser(User user) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_USER"));
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getContactInformation());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getLogin());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public List<User> showActiveUsers() {
        List<User> activeUsers = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("SELECT_ACTIVE_USERS"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String 	firstName = rs.getString(1);
                String 	lastName = rs.getString("last_name");
                String 	subscription = rs.getString("abonnement");
                String 	contactInformation = rs.getString("contact_information");
                String 	login = rs.getString("login");
                String 	password = rs.getString("password");
                boolean isLibrarian = Boolean.parseBoolean(rs.getString("is_librarian"));
                activeUsers.add(new User(id, firstName, lastName, subscription, contactInformation, login,
                        password, isLibrarian));
            }
            return activeUsers;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }
}
