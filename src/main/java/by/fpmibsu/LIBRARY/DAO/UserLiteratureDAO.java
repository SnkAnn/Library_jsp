package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.UserLiterature;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class UserLiteratureDAO implements GenericDAO<Integer, UserLiterature> {

    private static final UserLiteratureDAO INSTANCE = new UserLiteratureDAO();

    private static final String FIND_ALL = "SELECT * FROM user_literature";
    private static final String SAVE_SQL = "INSERT INTO user_literature (user_id,author_id) VALUES (?,?)";

    public static UserLiteratureDAO getInstance(){
        return INSTANCE;
    }
    private UserLiteratureDAO(){}

    @Override
    public Optional<UserLiterature> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(UserLiterature object){

    }

    public List<UserLiterature> findAll(){
        try(Connection connection= ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<UserLiterature> allLiterature = new ArrayList<>();
            while (resultSet.next()){
                allLiterature.add(buildUserLiterature(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private UserLiterature buildUserLiterature(ResultSet resultSet) throws SQLException {
        return new UserLiterature(
                resultSet.getObject("user_literature_id", Integer.class),
                resultSet.getObject("user_id", Integer.class),
                resultSet.getObject("literature_id", Integer.class)
        );
    }

    @Override
    @SneakyThrows
    public UserLiterature save(UserLiterature entity){
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getUserId());
            preparedStatement.setObject(2, entity.getLiteratureId());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setUserLiteratureId(generatedKeys.getObject("user_literature_id", Integer.class));

            return entity;
        }
    }
}