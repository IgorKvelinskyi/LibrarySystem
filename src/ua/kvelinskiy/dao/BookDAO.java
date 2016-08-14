package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.Genre;

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
 * The BookDAO class responds for getting and putting information about
 * books into and from database.
 * @author I.K.
 */

public class BookDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(BookDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public BookDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Book> ListBooksGenre (){
        List<Book> booksList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_LIST_BOOKS_GENRE"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre();
                String title = rs.getString("title");
                genre.setGenre(rs.getString("genre"));
                booksList.add(new Book(title, genre));            }
        return booksList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }
}
