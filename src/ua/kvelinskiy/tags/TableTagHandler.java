package ua.kvelinskiy.tags;

import org.apache.log4j.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The TableTagHandler class describes behavior of tag, which
 * implementing body of the table.
 *
 * @author I.K.
 */


public class TableTagHandler extends TagSupport implements DynamicAttributes {

        private static final Logger LOGGER = Logger.getLogger(TableTagHandler.class);
        private static final long serialVersionUID = 1L;
        private Map<String, Object> map = new HashMap<String, Object>();

        @Override
        public int doStartTag ()throws JspException {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("<tr>");
            for (String name : map.keySet()) {
                buffer.append("<th>")
                        .append(map.get(name))
                        .append("</th>");
            }
            buffer.append("</tr>");
            pageContext.getOut().print(buffer.toString());
        } catch (IOException ioException) {
            LOGGER.error("Error tag: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }


    public void setDynamicAttribute(String uri, String name, Object value)
            throws JspException {
        map.put(name, value);
    }


}
