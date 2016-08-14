package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.commands.interfaces.Command;

import javax.servlet.http.HttpSession;

/**
 * Go to home page.
 *
 * @author I.K.
 */

public class MainUserPageCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        String path = "/jsp/userPages/mainUserPage.jsp";
        return path;

    }
}
