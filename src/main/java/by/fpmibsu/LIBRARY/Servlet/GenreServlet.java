package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.LiteratureService;
import by.fpmibsu.LIBRARY.entity.Literature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Genre")
public class GenreServlet extends HttpServlet {
    private final LiteratureService literatureService = LiteratureService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String genre = request.getParameter("genre");
        List<String> subGenres = literatureService.getSubGenresByGenre(genre);
        List<Literature> books = literatureService.getBooksByGenre(genre);
        request.setAttribute("subGenres", subGenres);
        request.setAttribute("books", books);
        request.getRequestDispatcher("/JSP/Genre.jsp").forward(request, response);
    }
}
