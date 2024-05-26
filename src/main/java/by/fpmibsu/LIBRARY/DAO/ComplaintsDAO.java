package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Complaints;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import by.fpmibsu.LIBRARY.util.ConnectionManager;
import lombok.SneakyThrows;

public class ComplaintsDAO implements GenericDAO<Integer, Complaints> {

    private static final ComplaintsDAO INSTANCE = new ComplaintsDAO();
    private static final String FIND_ALL = "SELECT * FROM complaints";
    private static final String SAVE_SQL = "INSERT INTO complaints (author_id, text) VALUES (?,?)";

    public static ComplaintsDAO getInstance(){
        return INSTANCE;
    }
    private ComplaintsDAO(){}

    @Override
    public Optional<Complaints> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(Complaints object){

    }

    public List<Complaints> findAll(){
        try(Connection connection= ConnectionPool.getInstance().getConnection();
          var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Complaints> allLiterature = new ArrayList<>();
            while (resultSet.next()){
                allLiterature.add(buildComplaint(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    private Complaints buildComplaint(ResultSet resultSet) throws SQLException {
        return new Complaints(
                resultSet.getObject("complaint_id", Integer.class),
                resultSet.getObject("author_id", Integer.class),
                resultSet.getObject("text", String.class)
        );
    }

    @Override
    @SneakyThrows
    public Complaints save(Complaints entity){
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getComplaintID());
            preparedStatement.setObject(2, entity.getAuthorOfComplaintID());
            preparedStatement.setObject(3, entity.getTextOfComplaint());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setComplaintID(generatedKeys.getObject("complaint_id", Integer.class));

            return entity;
        }
    }
}