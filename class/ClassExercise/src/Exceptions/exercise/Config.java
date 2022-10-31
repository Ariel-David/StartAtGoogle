package startAtGoogle.Exceptions.exercise;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Config {

    public void configFile() {
        Properties prop = new Properties();
        String fileName = "src/startAtGoogle/Exceptions/exercise/app.config";
        try (FileInputStream input = new FileInputStream(fileName)) {
            //prop.load(input);
            if (prop.isEmpty()) {
                throw new IllegalArgumentException("file not initialized".toString());
            }
            Map<String, String> map = new HashMap<>();
            Enumeration<Object> value = prop.elements();
            Enumeration<Object> key = prop.keys();
            while (key.hasMoreElements() && value.hasMoreElements()) {
                map.put(key.nextElement().toString(), value.nextElement().toString());
            }
            if (prop.getProperty("hi") == null) {
                throw new IllegalArgumentException(String.format("key does not exist!"));
            }

        } catch (FileNotFoundException ex) {
            File file = new File("filename.config");
        } catch (IOException ex) {
            System.out.println("Invalid value");
        }
    }
}
