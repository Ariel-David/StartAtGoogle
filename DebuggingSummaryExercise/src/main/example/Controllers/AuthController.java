package main.example.Controllers;
import main.example.Services.AuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthController {
    private final Validation validation;
    private static Logger log = LogManager.getLogger(AuthController.class.getName());

    public static AuthController getInstance() {
        if (instance == null) instance = new AuthController();
        return instance;
    }

    private static AuthController instance;

    private AuthController() {
        validation = new Validation();
    }

    public String tryLogin(String email, String password) {
        try {
            validation.isValidEmail(email);
            validation.isValidPassword(password);
            String token = AuthService.getInstance().login(email, password);
            System.out.println("Login succeeded.");
            return token;
        }
        catch (IllegalArgumentException exp)
        {
            log.fatal("login failed!");
            ControllersUtil.printErrorToCmd("Login failed.",exp.getMessage());
            return null;
        }
    }

    public void checkToken(String email, String Token) {
        if(Token==null || Token.isEmpty())
        {
            log.error("login failed!");
            ControllersUtil.printErrorToCmd("Login failed.","The token is null or empty.\n You must login first to get a valid token.");
            return;
        }
        AuthService.getInstance().checkToken(email, Token);
    }
}
