package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Show user's list.
 * @author I.K.
 */

public class ListClientsCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            session.invalidate();
            return "/jsp/index.jsp";
        }
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        List<User> customersList = new ArrayList<>();
        customersList.addAll(userDao.showActiveUsers());
        session.setAttribute("customersList", customersList);
        session.setAttribute("requestStatus", "Choose");
        String path = "/jsp/librarianPages/listClients.jsp";
        return path;
    }
}
