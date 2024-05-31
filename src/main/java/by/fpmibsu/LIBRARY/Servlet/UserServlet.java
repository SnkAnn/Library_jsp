package by.fpmibsu.LIBRARY.Servlet;

import by.fpmibsu.LIBRARY.Service.UserService;
import by.fpmibsu.LIBRARY.entity.User;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    private User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        user = userService.getUser(userID);
        request.setAttribute("userID", user.getUserID());
        request.setAttribute("userImage", user.getImage());
        request.setAttribute("userDescription", user.getInformation());
        request.setAttribute("lastBookId",user.getLast_book());
        request.setAttribute("lastBook",userService.getBookById(user.getLast_book()));
        request.setAttribute("authorID",userService.getAuthorByBookId( user.getLast_book()));
        request.getRequestDispatcher("/JSP/UserPage.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID= user.getUserID();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        // Получаем JSON из запроса и извлекаем из него данные
        String json = sb.toString();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        // Проверяем наличие userID в JSON
        if (jsonObject.containsKey("userID")) {
           // int userID = ((Long) jsonObject.get("userID")).intValue();

            // Обновляем изображение, если оно присутствует в запросе
            if (jsonObject.containsKey("imageUrl")) {
                String imageUrl = (String) jsonObject.get("imageUrl");
                userService.updateUserProfilePicture(userID, imageUrl);
            }

            // Обновляем описание, если оно присутствует в запросе
            if (jsonObject.containsKey("description")) {
                String newDescription = (String) jsonObject.get("description");
                userService.updateUserDescription(userID, newDescription);
            }

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
