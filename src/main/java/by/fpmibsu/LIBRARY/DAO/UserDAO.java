package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.User;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class UserDAO implements GenericDAO<Integer, User> {

    private static final UserDAO INSTANCE = new UserDAO();

    private static final String SAVE_SQL = "INSERT INTO users (login, password, mail) VALUES (?,?,?)";
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = "SELECT * FROM users WHERE login = ? AND password = ?";

    public static UserDAO getInstance(){
        return INSTANCE;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(User object){

    }

    @Override
    @SneakyThrows
    public User save(User entity){
//        try(var connection = ConnectionManager.get();
        try(Connection connection=ConnectionPool.getInstance().getConnection();
        var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getLogin());
            preparedStatement.setObject(2, entity.getPassword());
            preparedStatement.setObject(3, entity.getMail());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setUserID(generatedKeys.getObject("user_id", Integer.class));

            return entity;
        }
    }

    public Optional<User> findByEmailAndPassword(String login, String password) {
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();
            User user = null;
            if(resultSet.next()){
                user = buildEntity(resultSet);
            }

            return Optional.ofNullable(user);
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private User buildEntity(ResultSet resultSet) throws SQLException{
        return User.builder()
                .UserID(resultSet.getObject("user_id", Integer.class))
                .login(resultSet.getObject("login", String.class))
                .password(resultSet.getObject("password", String.class))
                .mail(resultSet.getObject("mail", String.class))
                .build();
    }
}
