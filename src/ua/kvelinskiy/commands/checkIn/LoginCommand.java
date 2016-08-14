package ua.kvelinskiy.commands.checkIn;

import ua.kvelinskiy.commands.CommandSessionHelper;
import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;
import javax.servlet.http.HttpSession;

/**
 * 1.User authentication.
 * 2.User identification(librarian or user) and account entry.
 *
 * @author I.K.
*/

public class LoginCommand implements Command {
/**
 * 1.User authentication.
 * 2.User identification(librarian or user) and account entry.
 *
 * @author I.K.
 */
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String login = wrapper.getParameter("login");
        String password = wrapper.getParameter("password");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        if (userDao.isExist(user)) {
            user = userDao.getUserData(user);
            session.setAttribute("user", user);
            CommandSessionHelper.setUserSessionAttributes(wrapper, user);
            if (user.isLibrarian()) {
                session.setAttribute("requestStatus", "Choose");
                path = "/jsp/librarianPages/mainLibrarianPage.jsp";
                return path;
            } else {
                path = "/jsp/userPages/mainUserPage.jsp";
                return path;
            }
        } else {
            path = "/jsp/errorPage.jsp";
            return path;
        }
    }
}
