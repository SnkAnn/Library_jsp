package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Genre;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import lombok.SneakyThrows;

public class GenreDAO {


    // SQL запросы
    private static final String INSERT_GENRE_SQL = "INSERT INTO genres (name) VALUES (?)";
    private static final String SELECT_ALL_GENRES_SQL = "SELECT * FROM genres";
    private static final String DELETE_GENRE_SQL = "DELETE FROM genres WHERE id = ?";
    @SneakyThrows
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        String query = "SELECT  * FROM genres";

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt("genre_id"));
                genre.setName(resultSet.getString("genre_name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Genres loaded: " + genres.toString());
        return genres;
    }


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
