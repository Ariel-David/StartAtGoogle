package app.repositories;
import app.entity.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class UserRepositry {

    private static final String PATH = "src/main/java/DataSource/jsons/";
    private static final Gson gson = new Gson();
    private static final Map<String, User> usersByEmails = new HashMap<>();
    private static UserRepositry instance;


    public static UserRepositry getInstance() {
        if(instance == null)
            instance = new UserRepositry();
        return instance;
    }

    public static List<User> getUsers() {
        return usersByEmails.values().stream().collect(Collectors.toList());
    }

    public static void addNewUser(User user) {
        int userId = user.getId();
        try {
            Writer writer = new FileWriter(PATH + "\\User" + userId+".txt");
            new Gson().toJson(user, writer);
            writer.close();
            usersByEmails.put(user.getEmail(), user);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id) {
        File userJsonFile = new File(PATH + "User" + id+".txt");
        FileReader fileReader;
        if (!userJsonFile.exists()) {
            System.out.println("User " + id + "does not exist");
            return null;
        }
        try {
            fileReader = new FileReader(userJsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(fileReader, User.class);
    }

    public static User getUserByEmail(String email) {
        return(usersByEmails.get(email));
    }


    public void updateUsersName(String email, String newName)   {
        User tempUser = throwUserNotFoundException((getUserByEmail(email)),email);
        tempUser.setName(newName);
        addNewUser(tempUser);
    }

    public static void updateUsersPassword(String email, String newPassword)   {
        User tempUser = throwUserNotFoundException(getUserByEmail(email),email);
        tempUser.setPassword(newPassword);
        addNewUser(tempUser);
    }


    public void updateUsersEmail(String email, String newEmail)   {
        User tempUser = throwUserNotFoundException(getUserByEmail(email),email);
        tempUser.setEmail(newEmail);
        addNewUser(tempUser);
    }
    private static User throwUserNotFoundException(User user, String email)
    {
        if(user!=null)return user;
        throw new NullPointerException("No user with the following email address: "+ email+ " was found in the system.");
    }

    public boolean userIsExist(String email)
    {
        System.out.println(usersByEmails.keySet() + " "+email);
        return(usersByEmails.containsKey(email));
    }

    public void deleteByEmail(String email) {
        usersByEmails.remove(email);
    }
}
