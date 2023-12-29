package libraryManagement.model;

import java.util.List;

public class Book {

    Integer id;

    String title;

    List<String> author;

    List<String> publisher;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public List<String> getAuthor() {
        return author;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
