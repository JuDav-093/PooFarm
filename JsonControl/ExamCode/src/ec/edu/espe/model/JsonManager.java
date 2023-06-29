package ec.edu.espe.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class JsonManager {
    
    public void createJson(ArrayList<Farm> animals) {
        // Convierte la lista completa a JSON y guárdala en el archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(animals);

        try (FileWriter fileWriter = new FileWriter("SavedFiles/animalsFarm.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    
    public String readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("SavedFiles/animalsFarm.json"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            System.out.println("Hubo un error al leer el archivo: " + e.getMessage());
            return "";
        }
    }
    
    
}
