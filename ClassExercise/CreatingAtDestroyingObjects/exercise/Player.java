package CreatingAtDestroyingObjects.exercise;

import java.util.*;

public class Player {
    public String Name;

    public String Gender;
    public int Grade;

    public List<String> Positions = new ArrayList<>(Arrays.asList("Goal Keeper", "Defender", "Midfielder", "Attacker"));

    public int JNumber;
    public String playerPos;

    public NameGenerator name_generator = new NameGenerator();

    public Player(String gender) {
        if (gender == "male") {
            Name = random_male_name();
            gender = "male";
        } else {
            Name = random_female_name();
            gender = "female";

        }
        Grade = random_Grade();
    }

    public static Player createPlayer(String name, String gender, int grade, int Jnumber, String pos) {
        Player p = new Player(gender);
        p.setName(name);
        p.setGrade(grade);
        p.setJNumber(Jnumber);
        p.setPlayerPos(pos);
        return p;
    }

    public int random_Grade() {
        final int max = 100;
        Random generator = new Random();
        int res = generator.nextInt(max) + 1;
        return res;
    }

    public String random_male_name() {
        return name_generator.pickMaleName(name_generator.males);
    }

    public String random_female_name() {
        return name_generator.pickFemaleName(name_generator.females);
    }

    public void setName(String name) {
        Name = name;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public void setJNumber(int JNumber) {
        this.JNumber = JNumber;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public String getName() {
        return Name;
    }

    public int getGrade() {
        return Grade;
    }

    public List<String> getPositions() {
        return Positions;
    }

    public int getJNumber() {
        return JNumber;
    }

    public String getPlayerPos() {
        return playerPos;
    }
}
