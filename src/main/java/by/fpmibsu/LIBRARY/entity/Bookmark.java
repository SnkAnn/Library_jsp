package by.fpmibsu.LIBRARY.entity;

public class Bookmark {

    public User userID;
    public Literature currentLiterature;
    public Bookmark() {}

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Literature getCurrentLiterature() {
        return currentLiterature;
    }

    public void setCurrentLiterature(Literature currentLiterature) {
        this.currentLiterature = currentLiterature;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "userID=" + userID +
                ", currentLiterature=" + currentLiterature +
                '}';
    }
}

