package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Literature;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class LiteratureDAO implements GenericDAO<Integer, Literature> {

    private static final LiteratureDAO INSTANCE = new LiteratureDAO();

    private static final String FIND_ALL = "SELECT * FROM literature";
    private static final String SAVE_SQL = "INSERT INTO literature (title,author_id,review_id,text,amount_of_read,adding_time,image,genre) VALUES (?,?,?,?,?,?,?,?)";

    public static LiteratureDAO getInstance(){
        return INSTANCE;
    }
    private LiteratureDAO(){}

    @Override
    public Optional<Literature> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(Literature object){

    }

    public List<Literature> findAll(){
        try(Connection connection= ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Literature> allLiterature = new ArrayList<>();
            while (resultSet.next()){
                allLiterature.add(buildLiterature(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private Literature buildLiterature(ResultSet resultSet) throws SQLException {
        return new Literature(
                resultSet.getObject("literature_id", Integer.class),
                resultSet.getObject("title", String.class),
                resultSet.getObject("author_id", Integer.class),
                resultSet.getObject("review_id", Integer.class),
                resultSet.getObject("text", String.class),
                resultSet.getObject("amount_of_reads", Integer.class),
                resultSet.getObject("adding_time", String.class),
                resultSet.getObject("genre", String.class)
        );
    }

    @Override
    @SneakyThrows
    public Literature save(Literature entity){
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getTitle());
            preparedStatement.setObject(2, entity.getAuthor());
            preparedStatement.setObject(3, entity.getReview());
            preparedStatement.setObject(4, entity.getText());
            preparedStatement.setObject(5, entity.getAmountOfReads());
            preparedStatement.setObject(6, entity.getAddingTime());
            preparedStatement.setObject(7, entity.getImage());
            preparedStatement.setObject(8, entity.getGenre());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setLiteratureID(generatedKeys.getObject("literature_id", Integer.class));

            return entity;
        }
    }
}