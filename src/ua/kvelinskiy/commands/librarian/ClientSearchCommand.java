package ua.kvelinskiy.commands.librarian;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.BookDAO;
import ua.kvelinskiy.dao.CatalogueDAO;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.UserDAO;
import ua.kvelinskiy.entities.Book;
import ua.kvelinskiy.entities.Catalogue;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Search of the client according to the subscription number.
 * @author I.K.
 */

public class ClientSearchCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.invalidate();
            return "/jsp/index.jsp";
        }
        String subscription = wrapper.getParameter("abonnement");
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDao = factory.getUsersDAO();
        List<User> customersList = new ArrayList<>();
        customersList.addAll(userDao.showActiveUsers());
        boolean searchUser = false;
        User customer= null;
        for (User customerLibrary : customersList) {
            if (customerLibrary.getAbonnement().equals(subscription)) {
                customer = customerLibrary;
                session.setAttribute("client", customerLibrary);
                searchUser = true;
            }
        }
        if (searchUser) {
            List<BookStatus> statusList = new ArrayList<>();
            String [] staList ={"Reserve", "Free", "BeUsed","ReferenceRoom"};
            session.setAttribute("staList", staList);
            for (int i = 0; i < 4 ; i++) {
                statusList.add(new BookStatus(staList[i],(i)));
            }
            List<Catalogue> bookUserList = new ArrayList<>();
            CatalogueDAO catalogueDao = factory.getCatalogueDAO();
            bookUserList.addAll(catalogueDao.showUserBooksList(customer.getId()));
            session.setAttribute("clientId", customer.getId());
            session.setAttribute("bookUserList", bookUserList);
            session.setAttribute("statusList", statusList);
            session.setAttribute("requestStatus", "Choose");
            String path = "/jsp/librarianPages/clientSearch.jsp";
            return path;
        }
        session.setAttribute("requestStatus", "Fail");
        String path = "/jsp/librarianPages/mainLibrarianPage.jsp";
        return path;
    }

        public class BookStatus {
            private String status;
            private int idStatus;
            public BookStatus(String status, int idStatus) {
                this.status = status;
                this.idStatus = idStatus;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getIdStatus() {
                return idStatus;
            }

            public void setIdStatus(int idStatus) {
                this.idStatus = idStatus;
            }
        }

}
