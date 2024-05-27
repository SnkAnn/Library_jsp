package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.DAO.GenreDAO;
import by.fpmibsu.LIBRARY.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet {
    private GenreDAO genreDAO;

    @Override
    public void init() {
        genreDAO = new GenreDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Genre> genres = genreDAO.getAllGenres();
        System.out.println("Genres in Servlet: " + genres.toString());
        request.setAttribute("genres", genres);
        request.getRequestDispatcher("/JSP/Library.jsp").forward(request, response);
    }
}
