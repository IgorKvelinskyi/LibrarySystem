package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;

/**
 * The CommandSessionHelper class realizes the methods that we use in other
 * classes to make the code readable.
 * @author I.K.
 */

public class CommandSessionHelper {

    public static void setUserSessionAttributes(IRequestWrapper wrapper, User user) {
        HttpSession session = wrapper.getSession(true);
        session.setAttribute("id", user.getId());
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("lastName", user.getLastName());
        session.setAttribute("abonnement", user.getAbonnement());
        session.setAttribute("contactInformation", user.getContactInformation());
        session.setAttribute("login", user.getLogin());
        session.setAttribute("password", user.getPassword());
    }

    public static void setUserChangeProfile(IRequestWrapper wrapper, User user) {
        user.setFirstName(wrapper.getParameter("first_name"));
        user.setLastName(wrapper.getParameter("last_name"));
        user.setContactInformation(wrapper.getParameter("contact_information"));
        user.setPassword(wrapper.getParameter("password"));
    }
}
