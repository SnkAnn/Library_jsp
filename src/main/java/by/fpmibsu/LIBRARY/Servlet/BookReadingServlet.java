package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.LibraryService;
import by.fpmibsu.LIBRARY.Service.LiteratureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TextOfBook")
public class BookReadingServlet extends HttpServlet {
    private final LiteratureService literatureService= LiteratureService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String book = request.getParameter("book");

        List<String > bookList=new ArrayList<>();
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(String st:book.split("\n")){
            sb.append(st+"\n");
            if (count >= 20) {
                count = 0;
                bookList.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        String authorId=request.getParameter("authorID");
        // Получаем текст книги из базы данных или другого источника
        String bookText = literatureService.getBookTextForRead(book,authorId);

        // Устанавливаем текст книги как атрибут запроса
        request.setAttribute("bookText", bookText);
        request.getRequestDispatcher("/JSP/BookReading.jsp").forward(request, response);
    }
}
