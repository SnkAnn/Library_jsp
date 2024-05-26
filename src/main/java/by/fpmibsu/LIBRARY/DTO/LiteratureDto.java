package by.fpmibsu.LIBRARY.DTO;

import java.awt.*;

public class LiteratureDto {
    Integer literatureId;
    String text;
    Image image;

    public LiteratureDto(Integer literatureId, String text) {
        this.literatureId = literatureId;
        this.text = text;
    }

    public Integer getLiteratureId() {
        return literatureId;
    }

    public String getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }
}
