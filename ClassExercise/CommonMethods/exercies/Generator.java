package CommonMethods.exercies;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
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

    List<Integer> listOfNumbers = Arrays.asList(4188187, 3385412, 1778873, 4653359, 4013287, 6072770, 5138611, 4533494, 1309507, 4645389, 1480735, 3447994, 3835997, 2856562, 8997631, 5989029, 9073946, 6843074, 5750131, 2618979);

    List<String> listOfAreaCode = Arrays.asList("02","03","04","050","052","053","054","072","073","074","076","077");

    public String getFirstName() {
        int randomNum = ThreadLocalRandom.current().nextInt(listOfFirstName.size() - 1);
        return listOfFirstName.get(randomNum);
    }

    public String getLastName() {
        int randomNum = ThreadLocalRandom.current().nextInt(listOfLastName.size() - 1);
        return listOfLastName.get(randomNum);
    }

    public int getNumber() {
        int randomNum =  ThreadLocalRandom.current().nextInt(listOfNumbers.size() - 1);
        return listOfNumbers.get(randomNum);
    }

    public String getAreaCode() {
        int randomNum = ThreadLocalRandom.current().nextInt(listOfAreaCode.size() - 1);
        return listOfAreaCode.get(randomNum);
    }
}
