package service;

import by.fpmibsu.LIBRARY.DTO.CreateUserDto;
import by.fpmibsu.LIBRARY.DTO.UserDto;
import by.fpmibsu.LIBRARY.Service.UserService;
import by.fpmibsu.LIBRARY.exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

public class UserServiceTest {

    private final UserService userService = UserService.getInstance();

    @Test(dataProvider = "createUserDataProvider")
    public void testCreate(CreateUserDto createUserDto, Integer expectedUserId) {
        Integer userId = userService.create(createUserDto);
        Assert.assertEquals(userId, expectedUserId);
    }

    @Test(dataProvider = "createUserInvalidDataProvider", expectedExceptions = ValidationException.class)
    public void testCreateInvalid(CreateUserDto createUserDto) {
        userService.create(createUserDto);
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String mail, String password, Integer expectedUserId) {
        Optional<UserDto> userDtoOptional = userService.login(mail, password);
        Assert.assertTrue(userDtoOptional.isPresent());
        Assert.assertEquals(userDtoOptional.get().getUser_id(), expectedUserId);
    }

    @Test(dataProvider = "loginInvalidDataProvider")
    public void testLoginInvalid(String mail, String password) {
        Optional<UserDto> userDtoOptional = userService.login(mail, password);
        Assert.assertFalse(userDtoOptional.isPresent());
    }

    @DataProvider(name = "createUserDataProvider")
    public Object[][] createUserDataProvider() {
        CreateUserDto validUserDto = CreateUserDto.builder()
                .login("testuser")
                .password("password")
                .mail("testuser@test.com")
                .build();
        Integer validUserId = 1;

        return new Object[][]{
                {validUserDto, validUserId}
        };
    }

    @DataProvider(name = "createUserInvalidDataProvider")
    public Object[][] createUserInvalidDataProvider() {
        CreateUserDto invalidUserDto = CreateUserDto.builder()
                .login("")
                .password("")
                .mail("")
                .build();

        CreateUserDto invalidUserDto2 = CreateUserDto.builder()
                .login("")
                .password("pass")
                .mail("mail")
                .build();

        return new Object[][]{
                {invalidUserDto},
                {invalidUserDto2}
        };
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        CreateUserDto validUserDto = CreateUserDto.builder()
                .login("testuser")
                .password("password")
                .mail("testuser@test.com")
                .build();
        Integer validUserId = userService.create(validUserDto);

        CreateUserDto otherValidUserDto = CreateUserDto.builder()
                .login("testuser2")
                .password("password")
                .mail("testuser2@test.com")
                .build();
        Integer otherValidUserId = userService.create(otherValidUserDto);

        return new Object[][]{
                {validUserDto.getMail(), validUserDto.getPassword(), validUserId},
                {otherValidUserDto.getMail(), otherValidUserDto.getPassword(), otherValidUserId}
        };
    }

    @DataProvider(name = "loginInvalidDataProvider")
    public Object[][] loginInvalidDataProvider() {
        String invalidMail = "invalid@test.com";
        String invalidPassword = "invalidpassword";

        return new Object[][]{
                {invalidMail, invalidPassword}
        };
    }
}