package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Reviews;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class ReviewsDAO implements GenericDAO<Integer, Reviews> {

    private static final ReviewsDAO INSTANCE = new ReviewsDAO();

    private static final String FIND_ALL = "SELECT * FROM reviews";
    private static final String SAVE_SQL = "INSERT INTO reviews (reactions, author_of_review_id) VALUES (?,?)";

    public static ReviewsDAO getInstance(){
        return INSTANCE;
    }
    private ReviewsDAO(){}

    @Override
    public Optional<Reviews> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(Reviews object){

    }

    public List<Reviews> findAll(){
        try(Connection connection= ConnectionPool.getInstance().getConnection();
         var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Reviews> allLiterature = new ArrayList<>();
            while (resultSet.next()){
                allLiterature.add(buildReview(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private Reviews buildReview(ResultSet resultSet) throws SQLException {
        return new Reviews(
                resultSet.getObject("review_id", Integer.class),
                resultSet.getObject("reactions", String.class),
                resultSet.getObject("author_of_review_id", Integer.class)
        );
    }

    @Override
    @SneakyThrows
    public Reviews save(Reviews entity){
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getReactions());
            preparedStatement.setObject(2, entity.getAuthorOfReviewID());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setReviewID(generatedKeys.getObject("review_id", Integer.class));

            return entity;
        }
    }
}