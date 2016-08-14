package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;
import ua.kvelinskiy.entities.Genre;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The GenreDAO class responds for getting and putting information about
 * genre books from database.
 * @author I.K.
 */

public class GenreDAO {
    private DataSource ds;
    private static final Logger LOGGER = Logger.getLogger(GenreDAO.class);
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sqlstatements");

    public GenreDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<Genre> showGenresList(){
        List<Genre> genreList = new ArrayList<>();
        try (Connection conn = ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(resourceBundle.getString("GET_GENRES_LIST"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String 	genre = rs.getString("genre");
                genreList.add(new Genre(id, genre));
            }
            return genreList;
        } catch (SQLException e) {
            LOGGER.error("SQL error, " + e);
            return null;
        }
    }


}
