package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Show library books.
 * @author I.K.
 */

public class CatalogueBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/jsp/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        List<Catalogue> catalogueBooks = catalogueDao.getCatalogueListBooks();
        session.setAttribute("catalogueBooks", catalogueBooks);
        String path = "/jsp/librarianPages/catalogueBooks.jsp";
        return path;
    }
}
