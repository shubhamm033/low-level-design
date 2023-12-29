package splitwise.service;

import splitwise.model.User;
import splitwise.repo.UserRepo;

import java.util.List;

public class UserService {

    UserRepo userRepo = UserRepo.getInstance();

    public void addUser(String name, String email) {
        int id = userRepo.getId();
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        userRepo.addUser(user);
    }

    public List<User> getAllUser() {
        return userRepo.getUserList();

    }




}
