package app.service;
import app.entity.User;
import app.repositories.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositry userRepo;

    public UserService() {
        userRepo = new UserRepositry();
    }

    public User createUser(User user) {
        isEmailFree(user.getEmail());
        UserRepositry.getInstance().addNewUser(user);
        System.out.println("User is created!");
        return user;
    }

    private void isEmailFree(String email) {
        if (UserRepositry.getInstance().getUserByEmail(email)!=null)
            throw new IllegalArgumentException("There is another user with the email you type. please try another.");
    }

    public void changePassword(String email, String password) {
      UserRepositry.updateUsersPassword(email,password);
    }

    public void changeName(String email, String name) {
        userRepo.updateUsersName(email, name);
    }
    public void changeEmail(String email,String newEmail)
    {
        if(UserRepositry.getInstance().getUserByEmail(newEmail)!=null) throw  new IllegalArgumentException(String.format("The email address:%s is already in use.\nPlease trt another.",newEmail));
        UserRepositry.getInstance().updateUsersEmail(email, newEmail);
    }

    public List<User> getUsers() {
        return UserRepositry.getUsers();
    }

    public void deleteByEmail(String email) {UserRepositry.getInstance().deleteByEmail(email);}

}
