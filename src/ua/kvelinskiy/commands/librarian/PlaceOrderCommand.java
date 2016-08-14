package ua.kvelinskiy.commands.librarian;

import org.apache.log4j.Logger;
import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.entities.User;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	The PlaceOrderCommand class realizes placing of an order from the librarian or
 * 	acceptance of books in the library from the client (lending books for circulation or
 * 	in the reading room).
 * @author I.K.
 */

public class PlaceOrderCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(PlaceOrderCommand.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd") {{ setLenient(false); }};

    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/jsp/index.jsp";
        }
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] idStatus = wrapper.getParameterValues("idStat");
        String[] idCatalogue = wrapper.getParameterValues("idCatal");
        String[] dateIssue = wrapper.getParameterValues("dateIssue");
        String[] dateReturn = wrapper.getParameterValues("dateReturn");
        FactoryDAO factory = FactoryDAO.getInstance();
        CatalogueDAO catalogueDao = factory.getCatalogueDAO();
        String [] statusList = (String[]) session.getAttribute("staList");
        int clientId = (int) session.getAttribute("clientId");
        String listStatus;
        int idTime;
        if (idStatus != null) {
            lab1:for (int i = 0; i < idStatus.length; i++) {
                listStatus = statusList[new Integer(idStatus[i])];
                idTime = clientId;
                if (listStatus.equals("Free")) {
                    idTime = 1;
                    dateIssue[i] = dateReturn[i] = String.valueOf(dateFormat.format(currentDate));
                }
                if (listStatus.equals("Reserve")) {
                    continue lab1;
                }
                if (isValidDate(dateIssue[i]) && isValidDate(dateReturn[i])){
                catalogueDao.updateCatalogueStatus(idCatalogue[i], listStatus, idTime, dateIssue[i], dateReturn[i]);
                }else{
                    session.setAttribute("requestStatus", "IncorrectDate");
                }
            }
        }
        String path = "/jsp/librarianPages/mainLibrarianPage.jsp";
        return path;
    }

    public static boolean isValidDate(String date) {
        try {
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            LOGGER.error("Date Format error, " + e);
        }
        return false;
    }
}
