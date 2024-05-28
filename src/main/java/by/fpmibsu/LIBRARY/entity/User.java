package by.fpmibsu.LIBRARY.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int UserID;
    private String login;
    private String password;
    private String mail;
    public List<Complaints> complaints;
    public List<Bookmark> bookmarksOfUser;
    public Literature literatureOfAuthor;

    // Метод для получения имени пользователя
    public String getName() {
        // Возвращаем имя пользователя, в данном случае просто логин
        return login;
    }
}
