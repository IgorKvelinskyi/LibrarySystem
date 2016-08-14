package ua.kvelinskiy.commands.interfaces;

import javax.servlet.http.HttpSession;

/**
 * @author I.K.
 */

public interface IRequestWrapper {
    String getParameter(String key);
    HttpSession getSession(Boolean flag);
    String[] getParameterValues(String bookId);
    void setAttributes(String key, Object value);
    Object getAttributes(String name);

}
