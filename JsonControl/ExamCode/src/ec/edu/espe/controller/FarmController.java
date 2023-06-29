package ec.edu.espe.controller;


import ec.edu.espe.model.Farm;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmController {
    Farm farm;
    Scanner scanner = new Scanner(System.in);
    DataBaseController dbController = new DataBaseController();

    public void registrateAnimalFarm(ArrayList<Farm> animals) {
        int id;
        String color, weight, specie;
        System.out.println("Enter animal farm Id: ");
        id = scanner.nextInt();
        System.out.println("Enter the specie: ");
        specie = scanner.next();
        System.out.println("Enter animal color: ");
        color = scanner.next();
        System.out.println("Enter animal weight: ");
        weight = scanner.next();

        farm = new Farm(id, specie, color, weight);
        animals.add(farm);

        ArrayList<Farm> animalsFromJson = dbController.readAnimalsFromJson();
        animalsFromJson.add(farm);
        dbController.saveAnimalsToMongoDB(animalsFromJson);

        System.out.println("Animal registered correctly");
    }

    public void printAnimal(ArrayList<Farm> animals) {
        ArrayList<Farm> animalsFromJson = dbController.readAnimalsFromJson();

        if (animalsFromJson.isEmpty()) {
            System.out.println("No animals registered.");
        } else {
            System.out.println("Registered Animals:");
            for (Farm animal : animalsFromJson) {
                System.out.println("Animal Farm ID: " + animal.getId());
                System.out.println("Specie: " + animal.getSpecie());
                System.out.println("Color: " + animal.getColor());
                System.out.println("Weight: " + animal.getWeight());
                System.out.println("--------------------------");
            }
        }
    }

    public void deleteAnimalList() {
        dbController.deleteAllAnimalsFromMongoDB();
        System.out.println("All Animals deleted correctly");
    }

    public void editObject() {
        System.out.println("Enter the ID of the animal to edit: ");
        int id = scanner.nextInt();
        boolean found = false;

        ArrayList<Farm> animalsFromJson = dbController.readAnimalsFromJson();

        for (Farm animal : animalsFromJson) {
            if (animal.getId() == id) {
                found = true;

                System.out.println("Enter the new specie: ");
                String newSpecie = scanner.next();
                animal.setSpecie(newSpecie);

                System.out.println("Enter the new color: ");
                String newColor = scanner.next();
                animal.setColor(newColor);

                System.out.println("Enter the new weight: ");
                String newWeight = scanner.next();
                animal.setWeight(newWeight);

                System.out.println("Animal with ID " + id + " has been updated.");
                break;
            }
        }

        if (!found) {
            System.out.println("Animal with ID " + id + " was not found.");
        }

        dbController.saveAnimalsToMongoDB(animalsFromJson);
    }
}

