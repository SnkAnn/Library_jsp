package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.LibraryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Library")
public class LibraryServlet extends HttpServlet {
    private final LibraryService genreService = LibraryService.getInstance();

    private static Logger logger = LogManager.getLogger(LibraryServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> genres = genreService.getAllGenres();
        req.setAttribute("genres", genres);
        req.getRequestDispatcher("/JSP/Library.jsp").forward(req, resp);
        logger.debug("Genres were successfully loaded and forwarded to Library.jsp");
    }
}
