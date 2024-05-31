package by.fpmibsu.LIBRARY.entity;

import java.awt.*;

public class Literature {
    private int literatureID;
    private int authorLiteratureID;
    private int reviewLiteratureID;
    private Image image;
    private String genre;
    private String subGenre;
    private String title;
    public User author;
    public Reviews review;
    private String text;
    private String textOfBook;
    private int amountOfReads;
    private String addingTime;
    public Literature(){}

    public Literature(int literatureID, String title, int authorLiteratureID, int reviewLiteratureID, String text, int amountOfReads, String addingTime, String genre,String subGenre,String textOfBook) {
        this.literatureID = literatureID;
        this.authorLiteratureID = authorLiteratureID;
        this.reviewLiteratureID = reviewLiteratureID;
        this.genre = genre;
        this.title = title;
        this.text = text;
        this.amountOfReads = amountOfReads;
        this.addingTime = addingTime;
        this.subGenre=subGenre;
        this.textOfBook=textOfBook;
    }

    public Literature(int literatureID, String title, int authorLiteratureID, int reviewLiteratureID, String text, int amountOfReads, String addingTime, Image image, String genre,String subGenre,String textOfBook) {
        this.literatureID = literatureID;
        this.authorLiteratureID = authorLiteratureID;
        this.reviewLiteratureID = reviewLiteratureID;
        this.image = image;
        this.genre = genre;
        this.title = title;
        this.text = text;
        this.amountOfReads = amountOfReads;
        this.addingTime = addingTime;
        this.subGenre=subGenre;
        this.textOfBook=textOfBook;
    }

    public Literature(String title, int authorLiteratureID, int reviewLiteratureID, String text,
                      int amountOfReads, String addingTime, Image image, String genre,String subGenre,String textOfBook) {
        this.title = title;
        this.authorLiteratureID = authorLiteratureID;
        this.reviewLiteratureID = reviewLiteratureID;
        this.text = text;
        this.amountOfReads = amountOfReads;
        this.addingTime = addingTime;
        this.image=image;
        this.genre=genre;
        this.subGenre=subGenre;
        this.textOfBook=textOfBook;
    }


    public Image getImage(){
        return image;
    }
    public String getGenre(){
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(int authorID) {
        this.authorLiteratureID = authorID;
    }

    public Reviews getReview() {
        return review;
    }

    public void setReview(Reviews review) {
        this.review = review;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAmountOfReads() {
        return amountOfReads;
    }

    public void setAmountOfReads(int amountOfReads) {
        this.amountOfReads = amountOfReads;
    }

    public String getAddingTime() {
        return addingTime;
    }

    public void setAddingTime(String addingTime) {
        this.addingTime = addingTime;
    }

    public int getLiteratureID() {
        return literatureID;
    }

    public void setLiteratureID(int literatureID) {
        this.literatureID = literatureID;
    }

    public int getAuthorLiteratureID() {
        return authorLiteratureID;
    }

    public void setAuthorLiteratureID(int authorLiteratureID) {
        this.authorLiteratureID = authorLiteratureID;
    }

    public int getReviewLiteratureID() {
        return reviewLiteratureID;
    }

    public void setReviewLiteratureID(int reviewLiteratureID) {
        this.reviewLiteratureID = reviewLiteratureID;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureID='" + literatureID + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", review=" + review +
                ", text='" + text + '\'' +
                ", amountOfReads=" + amountOfReads +
                '}';
    }

    public Object getSubGenre() {
        return subGenre;
    }

    public Object getTextOfBook() {
        return textOfBook;
    }

    public void setTextOfBook(String bookNewText) {
        this.textOfBook=bookNewText;
    }
}