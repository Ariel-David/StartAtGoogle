package app.controller;
import app.entity.User;
import app.repositories.UserRepositry;
import app.service.AuthService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    Validation validation;
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    public UserController() {
        this.userService = new UserService();
        this.authService = new AuthService();
        this.validation = new Validation();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        try {
            validation.isValidEmail(user.getEmail());
            logger.info("User with id number: "+user.getId()+"was created successfully");
            return ResponseEntity.ok(userService.createUser(user));
        } catch (RuntimeException exp)
        {
            logger.error("User cannot be created."+exp.getMessage());
        }
        return ResponseEntity.badRequest().body(user);
    }

    @RequestMapping(value = "/deleteByEmail" ,method = RequestMethod.DELETE)
    public ResponseEntity<List<User>> deleteByEmail(@RequestParam String email){
        userService.deleteByEmail(email);
        logger.info("User deleted successful");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/modify/password",method = RequestMethod.PATCH)
    public String modifyPassword(@RequestParam String email,@RequestParam String newPassword,@RequestParam String token)
    {
        try {
           authService.checkToken(email, token);
            userService.changePassword(email, newPassword);
            logger.info("Password of user with email: "+ email+ "was updated successfully");
            return("The password has been successfully changed:"+ UserRepositry.getInstance().getUserByEmail(email).toString());        }
        catch (IllegalArgumentException exp)
        {
            logger.error("Failed to change password."+exp.getMessage());
            return("Failed to change password to: "+newPassword);
        }
    }
    @RequestMapping(value="/modify/name",method = RequestMethod.PATCH)
    public String modifyUserName(@RequestParam String email,@RequestParam String newName,@RequestParam String token)
    {
        authService.checkToken(email, token);
        userService.changeName(email,newName);
        logger.info("Name was changed successfully");
        return("The name has been successfully changed:"+ UserRepositry.getInstance().getUserByEmail(email).toString());
    }

    @RequestMapping(value="/modify/email",method = RequestMethod.PATCH)
    public String modifyEmail(@RequestParam String email, @RequestParam String newEmail, @RequestParam String token)
    {
        try {
            validation.isValidEmail(newEmail);
            authService.checkToken(email, token);
            userService.changeEmail(email, newEmail);
            logger.info("Email was changed successfully");
            return("The email has been successfully changed:"+ UserRepositry.getInstance().getUserByEmail(email).toString());
        }
        catch (IllegalArgumentException | NullPointerException exp)
        {
            logger.info("Email's change was failed");
            return ("Failed to change email."+exp.getMessage());
        }
    }
}


