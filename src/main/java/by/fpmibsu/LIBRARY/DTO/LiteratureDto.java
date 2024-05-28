package by.fpmibsu.LIBRARY.DTO;

import java.awt.*;

public class LiteratureDto {
    Integer literatureId;
    String text;
    Image image;
    private String title;
    private String author;

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


        public LiteratureDto(int literatureID, String title, String author, String text) {
            this.literatureId = literatureID;
            this.title = title;
            this.author = author;
            this.text = text;
        }

        // Getters and setters

        public int getLiteratureID() {
            return literatureId;
        }

        public void setLiteratureID(int literatureID) {
            this.literatureId = literatureID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        public void setText(String text) {
            this.text = text;
        }

}
