package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.LiteratureService;
import by.fpmibsu.LIBRARY.Service.UserService;
import by.fpmibsu.LIBRARY.entity.Literature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FavoriteBook")
public class FavouriteBookServlet extends HttpServlet {
    private final LiteratureService literatureService = LiteratureService.getInstance();
    private final UserService userService=UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userID = request.getParameter("userID");

        List<Literature>userReadingBooks=userService.getUserReadingBooks(userID);
        request.setAttribute("books",userReadingBooks);
        request.setAttribute("userID",userID);
        request.getRequestDispatcher("/JSP/FavoriteBook.jsp").forward(request, response);
    }
}
