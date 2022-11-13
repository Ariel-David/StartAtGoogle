package app.service;
import app.entity.User;
import app.repositories.userRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private userRepositry userRepo;

    public UserService() {
        userRepo = new userRepositry();
    }

    public void validUniqueEmail(String email) {
        if (userRepo.getUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("A user with this email already exists. Choose another email.");
        }
    }

    public User createUser(String name, String email, String password) {
        isEmailFree(email);
        User u = new User(email, name, password);
        userRepo.addNewUser(u);
        System.out.println("User is created!");
        return u;
    }

    private void isEmailFree(String email) {
        if (userRepo.getUserByEmail(email).isPresent())
            throw new IllegalArgumentException("There is another user with the email you type. please try another.");
    }

    public void changePassword(String email, String password) {
      userRepositry.updateUsersPassword(email,password);
    }

    public void changeName(String email, String name) {
        userRepo.updateUsersName(email, name);
    }
    public void changeEmail(String email,String newEmail)
    {
        if(userRepo.getUserByEmail(newEmail).isPresent()) throw  new IllegalArgumentException(String.format("The email address:%s is already in use.\nPlease trt another.",newEmail));
        userRepo.updateUsersEmail(email, newEmail);
    }

    public List<User> getUsers() {
        return userRepositry.getUsers();
    }
}
