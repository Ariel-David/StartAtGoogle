package main.example.Services;
import main.example.DataSource.Repo;
import main.example.be.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class AuthService {
    public static AuthService getInstance() {
        if (instance == null) instance = new AuthService();
        return instance;
    }

    private static AuthService instance;
    private final Map<Integer, String> Tokens;

    private AuthService() {
        Tokens = new HashMap<>();
    }

    private String createNewToken(String email)
    {
        var s= AuthService.generateRandomToken(8);
        User user= ServicesUtil.isUserExists(Repo.getInstance().getUserByEmail(email));
        Tokens.put(user.getId(),s);
        return s;
    }

    public String login(String email, String password) {
        Repo repo = Repo.getInstance();
        User userByEmail = ServicesUtil.isUserExists(repo.getUserByEmail(email));
        if (userByEmail.getPassword().equals(password)) {
            return createNewToken(email);
        }
        throw new IllegalArgumentException("The password does not match the email.");
    }
    public boolean checkToken(String email,String Token)
    {
        Objects.requireNonNull(Token);
        User user = ServicesUtil.isUserExists(Repo.getInstance().getUserByEmail(email));
        return Tokens.get(user.getId()).equals(Token);
    }
    private static String generateRandomToken(int length)
    {
        assert length>0;
        String result="";
        for (int i = 0; i < length; i++) {
            result+=(char) ThreadLocalRandom.current().nextInt(33,125);
        }
        return result;
    }
}
