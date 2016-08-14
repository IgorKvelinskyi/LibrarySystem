package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.User;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * List of books by genre.
 * @author I.K.
 */
public class ListBooksGenreCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/jsp/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        BookDAO bookDao = factory.getBooksDAO();
        List<Book> listBooksGenre = bookDao.ListBooksGenre();
        session.setAttribute("listBooksGenre", listBooksGenre);
        String path = "/jsp/userPages/listBooksGenre.jsp";
        return path;
    }
}
