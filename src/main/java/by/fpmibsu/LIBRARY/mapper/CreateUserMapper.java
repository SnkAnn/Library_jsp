package by.fpmibsu.LIBRARY.mapper;

import by.fpmibsu.LIBRARY.DTO.CreateUserDto;
import by.fpmibsu.LIBRARY.entity.User;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .login(object.getLogin())
                .password(object.getPassword())
                .mail(object.getMail())
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
