package by.fpmibsu.LIBRARY.entity;

public class Complaints {
    private int complaintID;
    private int authorOfComplaintID;

    public User authorOfComplaint;

    private String textOfComplaint;

    public Complaints(){}

    public Complaints(int authorOfComplaintID, String textOfComplaint) {
        this.authorOfComplaintID = authorOfComplaintID;
        this.textOfComplaint = textOfComplaint;
    }

    public Complaints(User authorOfComplaint, String textOfComplaint) {
        this.authorOfComplaint = authorOfComplaint;
        this.textOfComplaint = textOfComplaint;
    }

    public Complaints(int complaintID, int authorOfComplaintID, String textOfComplaint) {
        this.complaintID = complaintID;
        this.authorOfComplaintID = authorOfComplaintID;
        this.textOfComplaint = textOfComplaint;
    }

    public User getAuthorOfComplaint() {
        return authorOfComplaint;
    }

    public void setAuthorOfComplaint(User authorOfComplaint) {
        this.authorOfComplaint = authorOfComplaint;
    }

    public String getTextOfComplaint() {
        return textOfComplaint;
    }

    public void setTextOfComplaint(String textOfComplaint) {
        this.textOfComplaint = textOfComplaint;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public int getAuthorOfComplaintID() {
        return authorOfComplaintID;
    }

    public void setAuthorOfComplaintID(int authorOfComplaintID) {
        this.authorOfComplaintID = authorOfComplaintID;
    }

    @Override
    public String toString() {
        return "Complaints{" +
                "complaintID=" + complaintID +
                ", authorOfComplaint=" + authorOfComplaint +
                ", textOfComplaint='" + textOfComplaint + '\'' +
                '}';
    }
}