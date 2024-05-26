package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.DTO.CreateUserDto;
import by.fpmibsu.LIBRARY.Service.UserService;
import by.fpmibsu.LIBRARY.exception.ValidationException;
import by.fpmibsu.LIBRARY.util.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.URIParameter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(RegistrationServlet.class);
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("Registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ValidationException {
        var userDto = CreateUserDto.builder()
                .login(req.getParameter("username"))
                .password(req.getParameter("password"))
                .mail(req.getParameter("email"))
                .build();
        try {
            userService.create(userDto);
            req.setAttribute("user", userDto.getLogin());
            req.getRequestDispatcher("/JSP/UserPage.jsp").forward(req, resp);
            resp.sendRedirect("/JSP/UserPage.jsp");
        }catch (ValidationException exception){
            req.setAttribute("errors",exception.getErrors());
            doGet(req, resp);
            logger.error(exception);
            return;
        }
        logger.info("New listing successfully created");
    }
}