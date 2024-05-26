package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import lombok.SneakyThrows;

public class GenreDAO {


    // SQL запросы
    private static final String INSERT_GENRE_SQL = "INSERT INTO genres (name) VALUES (?)";
    private static final String SELECT_ALL_GENRES_SQL = "SELECT * FROM genres";
    private static final String DELETE_GENRE_SQL = "DELETE FROM genres WHERE id = ?";


    // Метод для закрытия ресурсов JDBC
    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для добавления нового жанра в базу данных
    public void addGenre(String name) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GENRE_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException | PersistentException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения списка всех жанров из базы данных
    @SneakyThrows
    public List<String> getAllGenres() {
        List<String> genres = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GENRES_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                genres.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    // Метод для удаления жанра по его ID
    @SneakyThrows
    public void deleteGenre(int id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GENRE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
