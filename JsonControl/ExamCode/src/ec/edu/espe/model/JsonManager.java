package ec.edu.espe.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class JsonManager {
    public void createJson(ArrayList<Farm> animals) {
        File file = new File("SavedFiles");
        file.mkdir();
        Gson gson = new Gson();
        
        String json = gson.toJson(animals);

        try (FileWriter fileWriter = new FileWriter("SavedFiles/animalsFarm.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }
    
}
