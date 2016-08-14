package ua.kvelinskiy.commands.checkIn;

import ua.kvelinskiy.commands.CommandSessionHelper;
import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
/**
 * Store the password in the User object and
 * create this user in the database.
 *
 * @author I.K.
 */
public class CheckInCommand implements Command {
/**
 * Store the password in the User object and
 * create this user in the database.
 *
 * @author I.K.
 */
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String password = wrapper.getParameter("password");
        User user = (User) session.getAttribute("user");
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
            user.setPassword(password);
            if (userDao.insertNewUser(user)) {
                user = userDao.getUserData(user);
                session.setAttribute("user", user);
                CommandSessionHelper.setUserSessionAttributes(wrapper, user);
                String path = "/jsp/userPages/userEditDataPage.jsp";
                return path;
            } else {
                session.setAttribute("checkInUserMessage", "AnotherPassword");
                String path = "/jsp/password.jsp";
                return path;
            }
    }
}
