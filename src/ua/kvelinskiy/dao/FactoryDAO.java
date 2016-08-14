package ua.kvelinskiy.dao;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * The FactoryDAO class makes all others DAO objects.
 * @author I.K.
 */

public class FactoryDAO {
    private static final Logger LOGGER = Logger.getLogger(FactoryDAO.class);
    private static FactoryDAO instance = null;
    private DataSource ds;

    private FactoryDAO() throws NamingException {
        InitialContext initContext = new InitialContext();
        ds = (DataSource) initContext.lookup("java:comp/env/jdbc/library");
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            try {
                instance = new FactoryDAO();
            } catch (NamingException ex) {
                LOGGER.error("Bad instance " + ex);
            }
        }
        return instance;
    }

    public UserDAO getUsersDAO() {
        return new UserDAO(ds);
    }

    public GenreDAO getGenresDAO(){
        return new GenreDAO(ds);
    }

    public CatalogueDAO getCatalogueDAO(){
        return new CatalogueDAO(ds);
    }

    public BookDAO getBooksDAO(){
        return  new BookDAO(ds);
    }
}
