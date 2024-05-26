package by.fpmibsu.LIBRARY.entity;

public class Reviews {
    private int reviewID;
    private int authorOfReviewID;
    private String reactions;
    public User authorOfReview;
    public Reviews() {}

    public Reviews(String reactions) {
        this.reactions = reactions;
    }

    public Reviews(String reactions, int authorOfReviewID) {
        this.reactions = reactions;
        this.authorOfReviewID = authorOfReviewID;
    }

    public Reviews(String reactions, User authorOfReview) {
        this.reactions = reactions;
        this.authorOfReview = authorOfReview;
    }

    public Reviews(int reviewID, String reactions, int authorOfReviewID) {
        this.reviewID = reviewID;
        this.reactions = reactions;
        this.authorOfReviewID = authorOfReviewID;
    }

    public String getReactions() {
        return reactions;
    }

    public void setReactions(String reactions) {
        this.reactions = reactions;
    }

    public User getAuthorOfReview() {
        return authorOfReview;
    }

    public void setAuthorOfReview(User authorOfReview) {
        this.authorOfReview = authorOfReview;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getAuthorOfReviewID() {
        return authorOfReviewID;
    }

    public void setAuthorOfReviewID(int authorOfReviewID) {
        this.authorOfReviewID = authorOfReviewID;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "reviewID='" + reviewID + '\'' +
                ", reactions='" + reactions + '\'' +
                ", authorOfReview=" + authorOfReview +
                '}';
    }
}