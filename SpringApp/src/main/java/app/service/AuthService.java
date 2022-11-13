package app.service;
import app.entity.User;
import app.repositories.userRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthService {

    @Autowired
    private userRepositry userRepo;

    private final Map<Integer, String> Tokens;

    public AuthService() {
        this.userRepo = new userRepositry();
        this.Tokens = new HashMap<>();
    }

    private String createNewToken(String email)
    {
        String s= AuthService.generateRandomToken(8);
        User user= isUserExists(userRepo.getUserByEmail(email));
        Tokens.put(user.getId(),s);
        return s;
    }

    public String login(String email, String password) {
        User userByEmail = isUserExists(userRepositry.getUserByEmail(email));
        if (userByEmail.getPassword().equals(password)) {
            return createNewToken(email);
        }
        throw new IllegalArgumentException("The password does not match the email.");
    }
    public boolean checkToken(String email,String Token)
    {
        Objects.requireNonNull(Token);
        User user = isUserExists(userRepo.getUserByEmail(email));
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

    public static User isUserExists(Optional<User> user) {
        return user.orElseThrow(() -> {
            throw new IllegalArgumentException("There is no user with the email you type");
        });
    }
}
