package startAtGoogle.Methods.exercise.Program;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class generator {

    public String getFirstName() {
        int randomNum = ThreadLocalRandom.current().nextInt(listOfFirstName.size() - 1);
        return listOfFirstName.get(randomNum);
    }

    public String getLastName() {
        int randomNum = ThreadLocalRandom.current().nextInt(listOfLastName.size() - 1);
        return listOfLastName.get(randomNum);
    }

    List<String> listOfFirstName = Arrays.asList("Karen",
            "Jolene",
            "Jenna",
            "Bob",
            "Candice",
            "George",
            "Emely",
            "Barry",
            "Rosalee",
            "Sebastian"
    );

    List<String> listOfLastName = Arrays.asList("Adams",
            "Cann",
            "Ellis",
            "Jarrett",
            "Andersson",
            "Hale",
            "Myatt",
            "Quinton",
            "Summers",
            "Adler"
    );
}

