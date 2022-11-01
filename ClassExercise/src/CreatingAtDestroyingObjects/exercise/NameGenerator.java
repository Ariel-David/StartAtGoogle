package CreatingAtDestroyingObjects.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NameGenerator {

    public static final Logger LOG = Logger.getLogger(NameGenerator.class.getName());
    public static final String MALE_NAMES_FILE = "Files/Male_Names.txt";
    public static final String FEMALE_NAMES_FILE = "Files/Female_Names.txt";

    public Map<Float,String> females;
    public Map<Float,String> males;

    public Random random;


    public NameGenerator( ) {
    try{
            females = loadNames(FEMALE_NAMES_FILE);
            males = loadNames(MALE_NAMES_FILE);
        }
        catch (IOException e) {
            LOG.log(Level.WARNING, "IOException while loading names files.  You may not get any results!", e);
        }
    }

    public Map<Float, String> loadNames(final String file) throws IOException {
        TreeMap<Float, String> names = new TreeMap<>();
        InputStream is = NameGenerator.class.getResourceAsStream(file);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split("\\s+");
                names.put(Float.parseFloat(fields[2]), fields[0]);
                line = reader.readLine();
            }
        }

        return names;
    }

    public String pickMaleName(final Map map) {
        Random generator = new Random();
        Object[] values = males.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        return (String) randomValue;
    }

    public String pickFemaleName(final Map map) {
        Random generator = new Random();
        Object[] values = females.values().toArray();
        Object randomValue = values[generator.nextInt(values.length)];
        return (String) randomValue;
    }

}
