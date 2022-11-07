package CreatingAtDestroyingObjects.exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    public static String NameOfTheTeam;

    final int size = 11;
    public static List<Player> players = new ArrayList<>(11);
    public static List<String> positions_in_the_group = new ArrayList<>(Arrays.asList("Goal Keeper", "Defender", "Midfielder", "Attacker"));

    public final int GK = 1;
    public static int D_counter = 2;
    public static int M_counter = 2;

    public static int A_counter = 2;

    public Team() {
        NameOfTheTeam = "Blue Badgers";
    }

    public static void createMaleTeam() {
        players.clear();
        for (int i = 0; i < 11; i++) {
            Player p = new Player("male");
            p.JNumber = i;
            players.add(p);
        }
        set_GK();
        set_otherPositions();
    }

    public void createFemaleTeam() {
        players.clear();
        for (int i = 0; i < 11; i++) {
            Player p = new Player("female");
            p.JNumber = i;
            players.add(p);
        }
        set_GK();
        set_otherPositions();
    }

    public void createSpecificTeam(String name,String gender, int GK, int Defense, int Middlefiled, int Attack) throws Exception {
        NameOfTheTeam = name;
        if(gender == "male"){
            createMaleTeam();
        }
        else{
            createFemaleTeam();
        }

        int sum = GK + Defense + Middlefiled + Attack;
        if (sum != 11) {
            throw new Exception("Invalid Format");
        } else if (GK == 0 || Defense == 0 || Middlefiled == 0 || Attack == 0) {
            throw new Exception("Invalid Format");
        } else if (GK != 1 || Defense < 2 || Middlefiled < 2 || Attack < 2) {
            throw new Exception("Invalid Format");
        } else {
            D_counter = Defense;
            M_counter = Middlefiled;
            A_counter = Attack;
            set_otherPositions();
        }
    }

    public static void set_GK() {
        players.get(0).playerPos = positions_in_the_group.get(0);
    }

    public static void set_otherPositions() {
        int index = 1;
        while (D_counter != 0) {
            players.get(index).playerPos = positions_in_the_group.get(1);
            D_counter--;
            index++;
        }
        while (M_counter != 0) {
            players.get(index).playerPos = positions_in_the_group.get(2);
            M_counter--;
            index++;
        }
        while (A_counter != 0) {
            players.get(index).playerPos = positions_in_the_group.get(3);
            A_counter--;
            index++;
        }

        while (index < 11) {
            List<String> tempList = positions_in_the_group.subList(1, positions_in_the_group.size());
            players.get(index).playerPos = tempList.get((int) Math.floor(Math.random() * tempList.size()));
            index++;
        }
    }

    public void writeToFile(String fileName) {
        try(FileWriter myWriter = new FileWriter(fileName+".txt")) {
            for (int i = 0; i < players.size(); i++) {
                myWriter.write("Name: " + players.get(i).Name + "   Jersey number: " + players.get(i).JNumber + "   Grade: " + players.get(i).Grade + "   Positions: " + players.get(i).playerPos + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void printTeam(){
        for (int i=0; i<players.size(); i++){
            System.out.println("Name: "+players.get(i).getName()+"  Jersey Number: "+players.get(i).JNumber+"   Grade:"+players.get(i).getGrade()+"   Position:"+players.get(i).getPlayerPos());
        }
    }
}
