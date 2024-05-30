package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Literature;
import by.fpmibsu.LIBRARY.entity.User;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class UserDAO implements GenericDAO<Integer, User> {

    private static final UserDAO INSTANCE = new UserDAO();
    private static final String UPDATE_PROFILE_PICTURE_SQL = "UPDATE users SET image = ? WHERE user_id = ?";

    private static final String SAVE_SQL = "INSERT INTO users (login, password, mail,image,information,last_book) VALUES (?,?,?,?,?,?)";
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String GET_USER = "SELECT * FROM users WHERE user_id=?";
    private static final String GET_USER_ID = "SELECT DISTINCT user_id FROM users WHERE login=?";
    private static final String UPDATE_USER_TEXT = "UPDATE users SET information = ? WHERE user_id = ?";


    public static UserDAO getInstance() {
        return INSTANCE;
    }

    private static User buildUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getObject("user_id", Integer.class),
                resultSet.getObject("login", String.class),
                resultSet.getObject("password", String.class),
                resultSet.getObject("mail", String.class),
                resultSet.getObject("image", String.class),
                resultSet.getObject("information", String.class),
                resultSet.getObject("last_book", Integer.class)
        );
    }

    public static User getUser(String userID) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_USER)) {
            preparedStatement.setInt(1, Integer.parseInt(userID));
            var resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user = buildUser(resultSet);
            }
            return user;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }


    }

    public static Integer getUserID(String login) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_USER_ID)) {
            preparedStatement.setString(1, login);
            var resultSet = preparedStatement.executeQuery();
            Integer userID = 0;
            while (resultSet.next()) {
                userID = resultSet.getObject("user_id", Integer.class);
            }
            return userID;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User object) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
//        try(var connection = ConnectionManager.get();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getPassword());
            preparedStatement.setObject(3, entity.getMail());
            preparedStatement.setObject(4, entity.getImage());
            preparedStatement.setObject(5, entity.getInformation());
            preparedStatement.setObject(6, entity.getLastBook());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setUserID(generatedKeys.getObject("user_id", Integer.class));

            return entity;
        }
    }

    public Optional<User> findByEmailAndPassword(String login, String password) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }

            return Optional.ofNullable(user);
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .UserID(resultSet.getObject("user_id", Integer.class))
                .login(resultSet.getObject("login", String.class))
                .password(resultSet.getObject("password", String.class))
                .mail(resultSet.getObject("mail", String.class))
                .build();
    }

    @SneakyThrows
    public void updateUserProfilePicture(int userId, String filePath) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE_PICTURE_SQL)) {
            preparedStatement.setString(1, filePath);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        }
    }


    @SneakyThrows
    public void updateUserDescription(int userID, String newDescription) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_TEXT)) {
            preparedStatement.setString(1, newDescription);
            preparedStatement.setInt(2, userID);
            preparedStatement.executeUpdate();
        }
    }


}
