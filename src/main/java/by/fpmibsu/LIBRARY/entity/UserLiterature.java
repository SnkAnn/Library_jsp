package by.fpmibsu.LIBRARY.entity;

public class UserLiterature {

    private int userLiteratureId;
    private int userId;
    private int literatureId;

    public UserLiterature() {
    }

    public UserLiterature(int userId, int literatureId) {
        this.userId = userId;
        this.literatureId = literatureId;
    }

    public UserLiterature(int userLiteratureId, int userId, int literatureId) {
        this.userLiteratureId = userLiteratureId;
        this.userId = userId;
        this.literatureId = literatureId;
    }

    public int getUserLiteratureId() {
        return userLiteratureId;
    }

    public void setUserLiteratureId(int userLiteratureId) {
        this.userLiteratureId = userLiteratureId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    @Override
    public String toString() {
        return "UserLiterature{" +
                "userLiteratureId=" + userLiteratureId +
                ", userId=" + userId +
                ", literatureId=" + literatureId +
                '}';
    }
}
