package by.fpmibsu.LIBRARY.Service;

import by.fpmibsu.LIBRARY.DAO.GenreDAO;

import java.util.List;

public class LibraryService {
    private static final LibraryService INSTANCE = new LibraryService();
    private final GenreDAO genreDAO = new GenreDAO();

    private LibraryService() {}

    public static LibraryService getInstance() {
        return INSTANCE;
    }

    public List<String> getAllGenres() {
        return genreDAO.getAllGenres();
    }
}
