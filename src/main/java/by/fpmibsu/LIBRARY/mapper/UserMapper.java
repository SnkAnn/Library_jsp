package by.fpmibsu.LIBRARY.mapper;

import by.fpmibsu.LIBRARY.DTO.UserDto;
import by.fpmibsu.LIBRARY.entity.User;
import lombok.NoArgsConstructor;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto>{

    private static final UserMapper INSTANCE = new UserMapper();
    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .user_id(object.getUserID())
                .login(object.getLogin())
                .password(object.getPassword())
                .mail(object.getMail())
                .build();
    }

    public static UserMapper getInstance(){
        return INSTANCE;
    }
}
