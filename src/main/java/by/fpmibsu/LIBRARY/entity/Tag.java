package by.fpmibsu.LIBRARY.entity;

public class Tag {

    private int tagID;
    private int parentID;
    private String category;
    public Literature literature;
    public Tag() {}

    public Tag(int tagID) {this.tagID = tagID;}

    public Tag(int tagID, String category) {
        this.tagID = tagID;
        this.category = category;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "ID='" + tagID + '\'' +
                ", parentID='" + parentID + '\'' +
                ", categories='" + category + '\'' +
                '}';
    }
}