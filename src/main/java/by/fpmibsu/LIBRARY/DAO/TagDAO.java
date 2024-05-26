package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Tag;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class TagDAO implements GenericDAO<Integer, Tag> {

    private static final TagDAO INSTANCE = new TagDAO();

    private static final String FIND_ALL = "SELECT * FROM tags";
    private static final String SAVE_SQL = "INSERT INTO tags (tag_name) VALUES (?)";

    public static TagDAO getInstance(){
        return INSTANCE;
    }
    private TagDAO(){}

    @Override
    public Optional<Tag> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(Tag object){

    }

    public List<Tag> findAll(){
        try(Connection connection= ConnectionPool.getInstance().getConnection();
           var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Tag> allLiterature = new ArrayList<>();
            while (resultSet.next()){
                allLiterature.add(buildTag(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private Tag buildTag(ResultSet resultSet) throws SQLException {
        return new Tag(
                resultSet.getObject("tag_id", Integer.class),
                resultSet.getObject("tag_name", String.class)
        );
    }

    @Override
    @SneakyThrows
    public Tag save(Tag entity){
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getCategory());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setTagID(generatedKeys.getObject("tag_id", Integer.class));

            return entity;
        }
    }
}