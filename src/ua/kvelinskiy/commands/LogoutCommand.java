package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Completion of the session.
 * @author I.K.
 */

public class LogoutCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper){
        HttpSession session = wrapper.getSession(true);
        String path = "/jsp/index.jsp";
        session.invalidate();
        return path;
    }
}
