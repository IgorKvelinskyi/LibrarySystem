package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * The ChangeLanguageCommand class realizes the change of languages on UI.
 * @author I.K.
 */

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute (IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        String path = wrapper.getParameter("refer-path");
        String locale = (String) wrapper.getAttributes("language");
        session.setAttribute("locale", locale);
        if (path == null) {
            return "/jsp/index.jsp";
        } else {
            return path;
        }

    }


}
