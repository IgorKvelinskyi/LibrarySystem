package ua.kvelinskiy.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The SetCharFilter class responds for encoding requests and responses to UTF-8 format.
 * @author I.K.
 */

public class SetCharFilter implements Filter {
    private static final String UTF = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String encoding = servletRequest.getCharacterEncoding();
        if (!UTF.equalsIgnoreCase(encoding))
            servletResponse.setCharacterEncoding(UTF);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
