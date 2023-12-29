package libraryManagement.service;

import libraryManagement.model.User;
import libraryManagement.repo.NewUserRepo;


public class UserService {

    NewUserRepo newUserRepo = NewUserRepo.getInstance();

    public void addUser(String id) {
        User user = new User();
        user.setUserId(id);
        user.setBooksIssued(0);
        newUserRepo.addUser(user);

    }


    public User getUserById(String userId) {
        return newUserRepo.getUser(userId);

    }
}
