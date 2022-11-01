package startAtGoogle.classesAndInterfaces.exercise2.Farm;

import startAtGoogle.classesAndInterfaces.exercise2.Farm.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class AnimalExtension implements Animal {
    String gender;
    int id;
    int weight;

    List<String[]> randomListData = new ArrayList<>();

    public AnimalExtension() {
        generateAnimal();
    }

    public AnimalExtension(String gender, int id, int weight) {
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }

    public void generateAnimal(){
        randomList("src/startAtGoogle/classesAndInterfaces/exercise2/Farm/AnimalsGenerator.txt");
        Random random = new Random();
        int r = random.nextInt(200);
        gender = randomListData.get(r)[0];
        id = Integer.parseInt(randomListData.get(r)[1]);
        weight = Integer.parseInt(randomListData.get(r)[2]);
    }

    public void randomList(String File) {
        try {
            File myObj = new File(File);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] str = data.split(",");
                randomListData.add(str);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}



