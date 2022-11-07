package Services;

import DataSource.Repo;
import be.User;

public class UserService {

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }

    private UserService() {
    }

    public void validUniqueEmail(String email) {
        if (Repo.getInstance().getUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("A user with this email already exists. Choose another email.");
        }
    }

    public User createUser(String name, String email, String password) {
        isEmailFree(email);
        User u = new User(email, name, password);
        Repo.getInstance().addNewUser(u);
        System.out.println("User is created!");
        return u;
    }

    private void isEmailFree(String email) {
        if (Repo.getInstance().getUserByEmail(email).isPresent())
            throw new IllegalArgumentException("There is another user with the email you type. please try another.");
    }

    public void changePassword(String email, String password) {
      Repo.getInstance().updateUsersPassword(email,password);
    }

    public void changeName(String email, String name) {
        Repo.getInstance().updateUsersName(email, name);
    }
    public void changeEmail(String email,String newEmail)
    {
        if(Repo.getInstance().getUserByEmail(newEmail).isPresent()) throw  new IllegalArgumentException(String.format("The email address:%s is already in use.\nPlease trt another.",newEmail));
        Repo.getInstance().updateUsersEmail(email, newEmail);
    }
}
