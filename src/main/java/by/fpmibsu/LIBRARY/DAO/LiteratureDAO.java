package by.fpmibsu.LIBRARY.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.entity.Literature;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import lombok.SneakyThrows;

public class LiteratureDAO implements GenericDAO<Integer, Literature> {

    private static final LiteratureDAO INSTANCE = new LiteratureDAO();

    private static final String FIND_ALL = "SELECT * FROM literature";
    private static final String SAVE_SQL = "INSERT INTO literature (title,author_id,review_id,text,amount_of_read,adding_time,image,genre,sub_genre,text_of_book) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_TITLE = "SELECT * FROM literature WHERE title LIKE ?";
    private static final String FIND_BY_GENRE = "SELECT * FROM literature WHERE genre = ?";
    private static final String FIND_SUBGENRES_BY_GENRE = "SELECT DISTINCT sub_genre FROM literature WHERE genre = ? ";
    private static final String FIND_BOOKS_BY_GENRE_AND_SUBGENRE ="SELECT * FROM literature WHERE sub_genre = ? AND genre=? " ;
    private static final String GET_TEXT_OF_BOOK ="SELECT DISTINCT text_of_book FROM literature WHERE title = ? AND author_id=? ";
    private static final String GET_BOOK_BY_ID ="SELECT title FROM literature WHERE literature_id=?" ;
    private static final String GET_AUTHOR_BY_BOOK_ID ="SELECT author_id FROM literature WHERE literature_id=?" ;
    private static final String GET_BOOK__BY_ID = "SELECT * FROM literature WHERE literature_id=?";

    public static LiteratureDAO getInstance() {
        return INSTANCE;
    }

    private LiteratureDAO() {
    }

    @Override
    public Optional<Literature> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Literature object) {
    }

    public List<Literature> findAll() {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Literature> allLiterature = new ArrayList<>();
            while (resultSet.next()) {
                allLiterature.add(buildLiterature(resultSet));
            }
            return allLiterature;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Literature> findByTitle(String title) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BY_TITLE)) {
            preparedStatement.setString(1, "%" + title + "%");
            var resultSet = preparedStatement.executeQuery();
            List<Literature> literatureList = new ArrayList<>();
            while (resultSet.next()) {
                literatureList.add(buildLiterature(resultSet));
            }
            return literatureList;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Literature> getBooksByGenre(String genre) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BY_GENRE)) {
            preparedStatement.setString(1, genre);
            var resultSet = preparedStatement.executeQuery();
            List<Literature> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(buildLiterature(resultSet));
            }
            return books;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getSubGenresByGenre(String genre) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(FIND_SUBGENRES_BY_GENRE)) {
            preparedStatement.setString(1, genre);
            var resultSet = preparedStatement.executeQuery();
            List<String> subGenres = new ArrayList<>();
            while (resultSet.next()) {
                subGenres.add(buildSubGenre(resultSet));
            }
            return subGenres;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }
    private String buildSubGenre(ResultSet resultSet) throws SQLException {
        return new String(
                resultSet.getObject("sub_genre", String.class)
        );
    }
    private String buildTextOfBook(ResultSet resultSet) throws SQLException {
        return new String(
                resultSet.getObject("text_of_book", String.class)
        );
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
                resultSet.getObject("genre", String.class),
                resultSet.getObject("sub_genre", String.class),
                resultSet.getObject("text_of_book", String.class)
        );
    }



    @Override
    @SneakyThrows
    public Literature save(Literature entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getTitle());
            preparedStatement.setObject(2, entity.getAuthor());
            preparedStatement.setObject(3, entity.getReview());
            preparedStatement.setObject(4, entity.getText());
            preparedStatement.setObject(5, entity.getAmountOfReads());
            preparedStatement.setObject(6, entity.getAddingTime());
            preparedStatement.setObject(7, entity.getImage());
            preparedStatement.setObject(8, entity.getGenre());
            preparedStatement.setObject(9, entity.getSubGenre());
            preparedStatement.setObject(10, entity.getTextOfBook());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setLiteratureID(generatedKeys.getObject("literature_id", Integer.class));

            return entity;
        }
    }

    public List<Literature> getBooksBySubGenre(String subGenre, String genre) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BOOKS_BY_GENRE_AND_SUBGENRE)) {
            preparedStatement.setString(1, subGenre);
            preparedStatement.setString(2, genre);
            var resultSet = preparedStatement.executeQuery();
            List<Literature> subGenresBook = new ArrayList<>();
            while (resultSet.next()) {
                subGenresBook.add(buildLiterature(resultSet));
            }
            return subGenresBook;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBookTextForRead(String book, String authorID) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_TEXT_OF_BOOK)) {
            preparedStatement.setString(1, book);
            preparedStatement.setInt(2, Integer.parseInt(authorID));
            var resultSet = preparedStatement.executeQuery();
            StringBuilder str=new StringBuilder();
            while (resultSet.next()) {
                 str.append(resultSet.getObject("text_of_book", String.class));
                //str.append(buildTextOfBook(resultSet));
            }
            return str.toString();
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBookTitleById(int last_book) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_BOOK_BY_ID)) {
            preparedStatement.setInt(1, last_book);
            var resultSet = preparedStatement.executeQuery();
            String str=new String();
            while (resultSet.next()) {
                str= resultSet.getObject("title", String.class);
            }
            return str;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getAuthorByBookId(int last_book) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_AUTHOR_BY_BOOK_ID)) {
            preparedStatement.setInt(1, last_book);
            var resultSet = preparedStatement.executeQuery();
            int res=0;
            while (resultSet.next()) {
                res= resultSet.getObject("author_id", Integer.class);
            }
            return res;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }

    public Literature getBookById(String bookID) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             var preparedStatement = connection.prepareStatement(GET_BOOK__BY_ID)) {
            preparedStatement.setInt(1, Integer.parseInt(bookID));
            var resultSet = preparedStatement.executeQuery();
            Literature lit=new Literature();
            while (resultSet.next()) {
                lit= buildLiterature(resultSet);
            }
            return lit;
        } catch (SQLException | PersistentException e) {
            throw new RuntimeException(e);
        }
    }
}
