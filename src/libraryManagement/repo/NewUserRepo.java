package libraryManagement.repo;

import libraryManagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class NewUserRepo {

    public static NewUserRepo instance = null;

    List<User> userList = new ArrayList<>();



    private NewUserRepo() {}


    public static NewUserRepo getInstance() {

        if (instance == null) {
            instance = new NewUserRepo();
        }

        return instance;
    }


    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String userId) {
        for (User user: userList)
        if (user.getUserId().equals(userId)) {
            return user;
        }

        return null;
    }

}


