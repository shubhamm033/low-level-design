package splitwise.repo;

import splitwise.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepo extends BaseRepo{

    private static UserRepo instance = null;


    List<User> userList = new ArrayList<>();

    private UserRepo() {

    }

    public static UserRepo getInstance() {
        if (instance == null) {
            instance = new UserRepo();

        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }
    public User getUserById(int id) {

        Optional<User> user = userList.stream().filter(obj -> obj.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUserByName(String name) {

        Optional<User> user = userList.stream().filter(obj -> obj.getName().equals(name)).findFirst();
        return user.orElse(null);


    }





    }



