package libraryManagement.model;

public class Rack {

    Integer number;

    RackStatus rackStatus;

    BookCopy bookCopy;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RackStatus getRackStatus() {
        return rackStatus;
    }

    public void setRackStatus(RackStatus rackStatus) {
        this.rackStatus = rackStatus;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}
