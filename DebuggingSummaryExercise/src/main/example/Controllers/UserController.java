package main.example.Controllers;

import main.example.Services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
    private static UserController instance;
    private static Logger log = LogManager.getLogger(UserController.class.getName());

    Validation validation;

    public static UserController getInstance() {
        if (instance == null) instance = new UserController();
        return instance;
    }

    private UserController() {
        validation = new Validation();
    }

    public void createNewUser(String email, String password, String userName) {
        try {
            validation.isValidEmail(email);
            validation.isValidPassword(password);
            UserService.getInstance().createUser(userName, email, password);
        } catch (IllegalArgumentException exp)
        {
            log.fatal("User cannot be created!");
            ControllersUtil.printErrorToCmd("User cannot be created.",exp.getMessage());
        } catch (RuntimeException exp)
        {
            log.fatal("User cannot be created!");
            ControllersUtil.printErrorToCmd("User cannot be created.",exp.getMessage());
        }
    }
    public void modifyPassword(String email,String Token,String newPassword)
    {
        try {
            validation.isValidPassword(newPassword);
            AuthController.getInstance().checkToken(email, Token);
            UserService.getInstance().changePassword(email, newPassword);
            System.out.println("The password has been successfully changed.");
        }
        catch (IllegalArgumentException exp)
        {
            log.error("can't change password!");
            ControllersUtil.printErrorToCmd("Failed to change password.",exp.getMessage());
        }
    }
    public void modifyUserName(String email,String Token,String newUserName)
    {
        AuthController.getInstance().checkToken(email, Token);
        UserService.getInstance().changeName(email,newUserName);
        System.out.println("Your name has been successfully changed.");
    }
    public void modifyEmail(String email,String Token,String newEmail)
    {
        try {
            validation.isValidEmail(newEmail);
            AuthController.getInstance().checkToken(email, Token);
            UserService.getInstance().changeEmail(email, newEmail);
            System.out.println("Your email has been successfully changed.");
        }
        catch (IllegalArgumentException | NullPointerException exp)
        {
            log.error("can't change email!");
            log.trace("trace");
            ControllersUtil.printErrorToCmd("Failed to change email.",exp.getMessage());
        }
    }

}
