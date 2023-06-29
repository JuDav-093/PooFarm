package ec.edu.espe.controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.model.Farm;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DataBaseController {
    private static final String DATABASE_NAME = "Farm";
    private static final String COLLECTION_NAME = "Animal";

    private MongoCollection<Document> collection;
   private static final String username = "JuAD";
    private static final String password = "Juanis@2008";
    private static final String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
    private static final String encodedPassword = URLEncoder.encode(password, StandardCharsets.UTF_8);
    private static final String connectionString = "mongodb+srv://" + encodedUsername + ":" + encodedPassword + "@cluster0.xhgiup0.mongodb.net/Farm?retryWrites=true&w=majority";


    public DataBaseController() {
        connect();
    }

    private void connect() {
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .retryWrites(true)
                .build();

        var mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        collection = database.getCollection(COLLECTION_NAME);
    }

    public ArrayList<Farm> readAnimalsFromJson() {
        List<Document> documents = collection.find().into(new ArrayList<>());
        ArrayList<Farm> animals = new ArrayList<>();

        for (Document document : documents) {
            int id = document.getInteger("id");
            String specie = document.getString("specie");
            String color = document.getString("color");
            String weight = document.getString("weight");

            Farm animal = new Farm(id, specie, color, weight);
            animals.add(animal);
        }

        return animals;
    }

    public void saveAnimalsToMongoDB(ArrayList<Farm> animals) {
        collection.deleteMany(new Document());
        for (Farm animal : animals) {
            Document document = new Document("id", animal.getId())
                    .append("specie", animal.getSpecie())
                    .append("color", animal.getColor())
                    .append("weight", animal.getWeight());
            collection.insertOne(document);
        }
    }

    public void deleteAllAnimalsFromMongoDB() {
        collection.deleteMany(new Document());
    }
}
