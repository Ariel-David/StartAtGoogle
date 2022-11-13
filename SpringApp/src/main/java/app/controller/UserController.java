package app.controller;
import app.entity.User;
import app.service.AuthService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    Validation validation;

    public UserController() {
        this.userService = new UserService();
        this.authService = new AuthService();
        this.validation = new Validation();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers()
    {
        return ResponseEntity.ok(userService.getUsers());
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST,consumes = "application/json")
    public void createNewUser(String email, String password, String userName) {
        try {
            validation.isValidEmail(email);
            validation.isValidPassword(password);
            userService.createUser(userName, email, password);
        } catch (IllegalArgumentException exp)
        {
            printErrorToCmd("User cannot be created.",exp.getMessage());
        } catch (RuntimeException exp)
        {
           printErrorToCmd("User cannot be created.",exp.getMessage());
        }

    }

    public void modifyPassword(String email,String Token,String newPassword)
    {
        try {
            validation.isValidPassword(newPassword);
           authService.checkToken(email, Token);
            userService.changePassword(email, newPassword);
            System.out.println("The password has been successfully changed.");
        }
        catch (IllegalArgumentException exp)
        {
           printErrorToCmd("Failed to change password.",exp.getMessage());
        }
    }
    public void modifyUserName(String email,String Token,String newUserName)
    {
        authService.checkToken(email, Token);
        userService.changeName(email,newUserName);
        System.out.println("Your name has been successfully changed.");
    }
    public void modifyEmail(String email,String Token,String newEmail)
    {
        try {
            validation.isValidEmail(newEmail);
            authService.checkToken(email, Token);
            userService.changeEmail(email, newEmail);
            System.out.println("Your email has been successfully changed.");
        }
        catch (IllegalArgumentException | NullPointerException exp)
        {
           printErrorToCmd("Failed to change email.",exp.getMessage());
        }
    }

    public static void printErrorToCmd(String mainMessage,String defiles)
    {
        System.out.println(mainMessage);
        System.out.println(defiles);
    }
}


