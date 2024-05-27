package by.fpmibsu.LIBRARY.Service;

import by.fpmibsu.LIBRARY.DAO.GenreDAO;
import by.fpmibsu.LIBRARY.entity.Genre;
import java.util.List;

public class GenreService {
    private static final GenreService INSTANCE = new GenreService();
    private final GenreDAO genreDAO = new GenreDAO();

    private GenreService() {}

    public static GenreService getInstance() {
        return INSTANCE;
    }

    public List<String> getAllGenres() {
        return genreDAO.getAllGenres();
    }
}
