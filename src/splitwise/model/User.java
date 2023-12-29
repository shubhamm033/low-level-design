package splitwise.model;

public class User {

    Integer id;
    String email;

    String name;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


}
