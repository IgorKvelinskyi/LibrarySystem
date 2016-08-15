package ua.kvelinskiy.commands;

import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The RequestWrapper class responds for isolation of almost all methods of
 * HttpServletRequest class.
 *
 *  @author I.K.
 */

public class RequestWrapper implements IRequestWrapper {
    private HttpServletRequest request;
    private String [] strings;

    public RequestWrapper(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getParameter(String key) {
        return request.getParameter(key);
    }

    @Override
    public HttpSession getSession(Boolean flag) {
        return request.getSession(flag);
    }

    @Override
    public String[] getParameterValues(String s) {
        strings = request.getParameterValues(s);
        return strings;
    }

    @Override
    public void setAttributes(String key, Object value) {
        request.setAttribute(key, value);
    }

    @Override
    public Object getAttributes(String name) {
        return request.getParameter(name);
    }


}
