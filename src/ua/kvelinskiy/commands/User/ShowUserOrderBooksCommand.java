package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * 1. Shows the user's list of books;
 * 2. Updates the user's list of books - add selected (by user) books to the user's catalogue.
 * @author I.K.
 */

public class ShowUserOrderBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/jsp/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        String idUser = Integer.toString(user.getId());
        String[] idBooks = wrapper.getParameterValues("bookId");
        if(idBooks != null) {
            for (String idBook : idBooks) {
                catalogueDao.updateCatalogueUser(idBook, idUser);
            }
        }
        List<Catalogue> bookList = catalogueDao.showUserBooksList(user.getId());
        session.setAttribute("bookList", bookList);
        String path = "/jsp/userPages/bookCase.jsp";
        return path;
    }
}
