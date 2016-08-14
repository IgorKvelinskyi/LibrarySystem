package ua.kvelinskiy.commands.checkIn;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;
import javax.servlet.http.HttpSession;

/**
 * Sign up.
 * Login duplication check in the database.
 * Create an object of a new user
 * or output the error message "Login used."
 * @author I.K.
 */
public class SignUpCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String login = wrapper.getParameter("login");
        session.setAttribute("login", login);
        User user= new User();
        user.setLogin(login);
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        if (userDao.isExistLogin(user)) {
            session.setAttribute("login_used", "LoginUsed");
            String path = "/jsp/registration.jsp";
            return path;
        } else {
            session.setAttribute("user", user);
            String path = "/jsp/password.jsp";
            return path;
        }
    }
}
