package by.fpmibsu.LIBRARY.Service;

import by.fpmibsu.LIBRARY.DAO.LiteratureDAO;
import by.fpmibsu.LIBRARY.DTO.LiteratureDto;
import by.fpmibsu.LIBRARY.entity.Literature;

import java.util.List;
import java.util.stream.Collectors;

public class LiteratureService {
    private static final LiteratureService INSTANCE = new LiteratureService();
    private final LiteratureDAO literatureDAO = LiteratureDAO.getInstance();

    private LiteratureService(){}

    public List<LiteratureDto> findAll(){
        return literatureDAO.findAll().stream()
                .map(literature -> new LiteratureDto(
                        literature.getLiteratureID(), literature.getText()
                )).collect(Collectors.toList());
    }

    public List<String> getSubGenresByGenre(String genre) {
        return literatureDAO.getSubGenresByGenre(genre);
    }

    public List<Literature> getBooksByGenre(String genre) {
        return literatureDAO.getBooksByGenre(genre);
    }

    public static LiteratureService getInstance(){
        return INSTANCE;
    }
    public static Literature getAll(){
        return new Literature();
    }

    public List<Literature> getBooksBySubGenre(String subGenre, String genre) {
        return literatureDAO.getBooksBySubGenre(subGenre,genre);
    }
    public String getBookTextForRead(String book,String AuthorID){
        return literatureDAO.getBookTextForRead(book, AuthorID);
    }
}
