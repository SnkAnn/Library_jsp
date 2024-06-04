package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.LiteratureService;
import by.fpmibsu.LIBRARY.entity.Literature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YourBook")
public class BookAddingServlet extends HttpServlet {

    private final LiteratureService literatureService = LiteratureService.getInstance();
    //String userID=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String bookID=request.getParameter("bookID");
        request.setAttribute("userID",userID);
        if (bookID != null) {
            Literature book = literatureService.getBookByID(bookID);
            request.setAttribute("bookContent", book.getTextOfBook());
        } else {
            request.setAttribute("bookContent", "");
        }

        request.getRequestDispatcher("/JSP/BookAdding.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String bookID=request.getParameter("bookID");
        String bookContent = request.getParameter("bookContent");



        if (bookID.compareTo("")!=0) {
            //Literature book = literatureService.getBookByID("bookID");
            //book.setTextOfBook(bookContent);
            literatureService.updateBookText(bookContent,bookID);
        } else {
            // Create new book
            Literature book = new Literature();
            book.setAuthor(Integer.parseInt(userID));
            book.setTextOfBook(bookContent);
            literatureService.createBook(book);
        }

        response.sendRedirect("/YourBook?userID=" + userID);
    }
}
