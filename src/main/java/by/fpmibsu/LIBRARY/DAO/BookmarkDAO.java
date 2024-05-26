package by.fpmibsu.LIBRARY.DAO;

import by.fpmibsu.LIBRARY.entity.Bookmark;

import java.util.Optional;

public class BookmarkDAO implements GenericDAO<Integer, Bookmark> {

    private static final BookmarkDAO INSTANCE = new BookmarkDAO();

    public static BookmarkDAO getInstance(){
        return INSTANCE;
    }
    private BookmarkDAO(){}

    @Override
    public Optional<Bookmark> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id){
        return false;
    }

    @Override
    public void update(Bookmark object){

    }

    @Override
    public Bookmark save(Bookmark entity) {
        return null;
    }
}