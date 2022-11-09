package JavaBasic.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ListOfUser {
    User user;

    int size;
    public int userId = user.id;

    public static HashMap<Integer, User> hash = new HashMap<>();
    public static List<User> list = new ArrayList<>();

    static int activeCount;

    public ListOfUser(User user, int userId, HashMap<Integer, User> hash, int size) {
        this.user = user;
        this.userId = userId;
        this.hash = hash;
        this.activeCount = 0;
        this.size = size;

    }

    private static void generateRandomUserLists(int count) {
        for (int i = 0; i < count; i++) {
            int id = randomId();
            User u = userGenerate(id);
            hash.put(u.id, u);
            list.add(u);
        }
    }

    private static User getUserFromListById(int id) {
        boolean flag = false;
        User res = new User();
        for (User u : list) {
            if (u.id == id) {
                flag = true;
                res = u;
            }
            else{
                continue;
            }
        }
        return res;
    }

    private static User userGenerate(int id) {
        User u = new User();
        u.id = id;
        u.Name = randomName();
        return u;
    }

    private static String randomName() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }

    private static int randomId() {
        Random rand = new Random();
        int n = rand.nextInt(999999999);
        n = n + 1;
        return n;
    }

    public static int IsActivated() {
        for (User u: list) {
            if (u.IsActivated == true) {
                activeCount++;
            }
        }
        return activeCount;
    }

    public static void main(String[] args) {
        generateRandomUserLists(10);
        hash.forEach((userId, user) -> System.out.println("Id: " + userId + " Name: " + user.Name));
        System.out.println(IsActivated());
    }
}


