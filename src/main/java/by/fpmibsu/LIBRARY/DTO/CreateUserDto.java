package by.fpmibsu.LIBRARY.DTO;

import lombok.Builder;
import lombok.Value;

import java.awt.*;

@Value
@Builder
public class CreateUserDto {
    String login;
    String password;
    String mail;
    Image image;


}


