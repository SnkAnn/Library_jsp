package by.fpmibsu.LIBRARY.Service;

import by.fpmibsu.LIBRARY.DAO.UserDAO;
import by.fpmibsu.LIBRARY.DTO.CreateUserDto;
import by.fpmibsu.LIBRARY.DTO.UserDto;
import by.fpmibsu.LIBRARY.exception.ValidationException;
import by.fpmibsu.LIBRARY.mapper.CreateUserMapper;
import by.fpmibsu.LIBRARY.mapper.UserMapper;
import by.fpmibsu.LIBRARY.validator.CreateUserValidator;

import java.util.Optional;

public class UserService {
    private   static final String IMAGE_FOLDER="users/";
    private static final UserService INSTANCE = new UserService();
    //private static CreateUserValidator createUserValidator=CreateUserValidator.getInstance();
    private static final UserDAO userDAO = UserDAO.getInstance();
    private static final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private static final ImageService imageService=ImageService.getInstance();

    public Optional<UserDto> login (String mail, String password){
        return userDAO.findByEmailAndPassword(mail, password)
                .map(userMapper::mapFrom);
    }
    private static final CreateUserValidator createUserValidator=CreateUserValidator.getInstance();
    // private final UserDAO userDAO=UserDAO.getInstance();
    public static Integer create(CreateUserDto userDto){
        var validationResult=createUserValidator.isValid(userDto);
        if(!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
      //  imageService.upload(IMAGE_FOLDER+userDto.getImage().getSubmittedFileName(),userDto);
        userDAO.save(userEntity);
        return userEntity.getUserID();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }

}
