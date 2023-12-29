package libraryManagement.model;

public class BookCopy extends Book {

    String BookCopyId;

    BookCopyStatus bookCopyStatus;

    User issuedTo;

    String dueDate;

    @Override
    public String toString() {
        return "BookCopy{" +
                "BookCopyId='" + BookCopyId + '\'' +
                ", bookCopyStatus=" + bookCopyStatus +
                ", issuedTo=" + issuedTo +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    public BookCopyStatus getBookCopyStatus() {
        return bookCopyStatus;
    }

    public void setBookCopyStatus(BookCopyStatus bookCopyStatus) {
        this.bookCopyStatus = bookCopyStatus;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getBookCopyId() {
        return BookCopyId;
    }

    public User getIssuedTo() {
        return issuedTo;
    }

    public void setBookCopyId(String bookCopyId) {
        BookCopyId = bookCopyId;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setIssuedTo(User issuedTo) {
        this.issuedTo = issuedTo;
    }

}
