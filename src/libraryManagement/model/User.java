package libraryManagement.model;

public class User {

    String userId;

    Integer booksIssued;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(Integer booksIssued) {
        this.booksIssued = booksIssued;
    }
}
