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
import java.util.ArrayList;
import java.util.List;
/**
 * Show the list of books (based on the selected genre).
 * @author I.K.
 */

public class OrderBooksCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/jsp/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        List<Catalogue> bookList = new ArrayList<>();
        int idGenre = Integer.parseInt(wrapper.getParameter("idGenre"));
        bookList.addAll(catalogueDao.getListBooksGenre(idGenre));
        session.setAttribute("bookList", bookList);
        path = "/jsp/userPages/userOrderBooks.jsp";
        return path;
    }
}
