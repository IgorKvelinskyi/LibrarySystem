package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.CommandSessionHelper;
import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
/**
 * Update the user's profile.
 * @author I.K.
 */

public class UpdateUserProfileCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "/jsp/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        CommandSessionHelper.setUserChangeProfile(wrapper, user);
        if (userDao.updateUser(user)) {
            session.setAttribute("user", user);
            CommandSessionHelper.setUserSessionAttributes(wrapper,user);
            path = "/jsp/userPages/mainUserPage.jsp";
            return path;
        }
        path = "/jsp/userPages/userEditDataPage.jsp";
        return path;
    }
}
