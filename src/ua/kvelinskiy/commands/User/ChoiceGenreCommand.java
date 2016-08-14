package ua.kvelinskiy.commands.User;

import ua.kvelinskiy.commands.interfaces.Command;
import ua.kvelinskiy.commands.interfaces.IRequestWrapper;
import ua.kvelinskiy.dao.FactoryDAO;
import ua.kvelinskiy.dao.GenreDAO;
import ua.kvelinskiy.entities.Genre;
import ua.kvelinskiy.entities.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
/**
 * Show the list of genres of books for choice.
 *
 * @author I.K.
 */
public class ChoiceGenreCommand implements Command {
    @Override
    public String execute(IRequestWrapper wrapper) {
        HttpSession session = wrapper.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "/jsp/index.jsp";
        }
        String path;
        FactoryDAO factory = FactoryDAO.getInstance();
        GenreDAO genreDao = factory.getGenresDAO();
        List<Genre> genreList = new ArrayList<>();
        genreList.addAll(genreDao.showGenresList());
        session.setAttribute("genreList", genreList);
        path = "/jsp/userPages/choiceGenrePage.jsp";
        return path;
    }
}
