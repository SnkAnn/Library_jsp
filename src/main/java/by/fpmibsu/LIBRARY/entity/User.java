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
    private String image;
    private String information;
    private int last_book;
    private String reading_books_id;
    public List<Complaints> complaints;
    public List<Bookmark> bookmarksOfUser;
    public Literature literatureOfAuthor;

    public User(int userID,String login,String password,String mail,String image,String information,int last_book,String reading_books_id) {
        this.UserID=userID;
        this.login=login;
        this.password=password;
        this.mail=mail;
        this.image=image;
        this.information=information;
        this.last_book=last_book;
        this.reading_books_id=reading_books_id;
    }
    public User(int userID,String login,String password,String mail,String image,String information,int last_book) {
         this.UserID=userID;
         this.login=login;
         this.password=password;
         this.mail=mail;
         this.image=image;
         this.information=information;
         this.last_book=last_book;
    }
    public User(int userID,String login,String password,String mail,String image,String information ) {
        this.UserID=userID;
        this.login=login;
        this.password=password;
        this.mail=mail;
        this.image=image;
        this.information=information;
    }
    public User(int userID,String login,String password,String mail,String image ) {
        this.UserID=userID;
        this.login=login;
        this.password=password;
        this.mail=mail;
        this.image=image;

    }
    public User(int userID,String login,String password,String mail) {
        this.UserID=userID;
        this.login=login;
        this.password=password;
        this.mail=mail;
    }


    // Метод для получения имени пользователя
    public String getName() {
        // Возвращаем имя пользователя, в данном случае просто логин
        return login;
    }

    public String getImage() {
        return image;
    }

    public Integer getLastBook() {
        return last_book;
    }

    public String getInformation() {
        return information;
    }
}
