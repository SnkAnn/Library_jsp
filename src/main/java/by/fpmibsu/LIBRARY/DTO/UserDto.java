package by.fpmibsu.LIBRARY.DTO;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    Integer user_id;
    String login;
    String password;
    String mail;
}
