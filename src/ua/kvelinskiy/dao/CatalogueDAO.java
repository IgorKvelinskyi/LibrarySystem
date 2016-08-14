package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The CatalogueDAO class responds for getting and putting information about
 * using books in and from database.
 * @author I.K.
 */

public class CatalogueDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(CatalogueDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public CatalogueDAO(DataSource ds) {
        this.ds = ds;
    }

    public boolean updateCatalogueUser(String idBook, String idUser) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_CATALOGUE_USER_ID"));
            ps.setString(1, idUser);
            ps.setString(2, idBook);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    public List<Catalogue> getListBooksGenre(int idGenre){
        List<Catalogue> bookList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_BOOKS_LIST"));
            ps.setString(1, String.valueOf(idGenre));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setNumberPages(rs.getInt("number_pages"));
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublicationDate(rs.getDate("publication_date"));
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                String status = rs.getString("status");
                String orderStatus = rs.getString("order_status");
                bookList.add(new Catalogue(book, dateIssue, dateReturn, status, orderStatus));
            }
            return bookList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }

    public List<Catalogue> showUserBooksList(int idUser){
        List<Catalogue> bookList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_USER_BOOKS"));
            ps.setString(1, String.valueOf(idUser));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                Date dateIssue = rs.getDate("date_issue");
                Date dateReturn = rs.getDate("date_return");
                String status = rs.getString("status");
                String orderStatus = rs.getString("order_status");
                int id = rs.getInt("id");
                bookList.add(new Catalogue(id, status, orderStatus, dateIssue, dateReturn, book));
            }
            return bookList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }

    public List<Catalogue> getCatalogueListBooks() {
        List<Catalogue> catalogueListBooks = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_CATALOGUE_BOOKS"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                User user = new User();
                setUpPreparedStatementParametersCatalogueListBooks(rs, catalogueListBooks, book, user);
            }
            return catalogueListBooks;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }

    public boolean updateCatalogueStatus(String id, String status, int idUser, String dateIssue, String dateReturn) {
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("UPDATE_CATALOGUE_STATUS"));
            int idCatalogue = Integer.parseInt(id);
            ps.setString(1, status);
            ps.setString(2, status);
            ps.setInt(3, idUser);
            ps.setDate(4, java.sql.Date.valueOf(dateIssue));
            ps.setDate(5, java.sql.Date.valueOf(dateReturn));
            ps.setInt(6, idCatalogue);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return false;
        }
    }

    private void setUpPreparedStatementParametersCatalogueListBooks(ResultSet rs, List<Catalogue> catalogueListBooks, Book book, User user) throws SQLException {
        int idUser = rs.getInt("id_user");
        user.setAbonnement(rs.getString("abonnement"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        String status = rs.getString("status");
        String orderStatus = rs.getString("order_status");
        Date dateIssue = rs.getDate("date_issue");
        Date dateReturn = rs.getDate("date_return");
        catalogueListBooks.add(new Catalogue(idUser, status, orderStatus, dateIssue, dateReturn, book, user));
    }

}
