/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

import ec.edu.espe.model.JsonManager;
import ec.edu.espe.model.Farm;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class FarmController {
    Farm farm;
    Scanner scanner = new Scanner(System.in);
    JsonManager jsonManager = new JsonManager();
    
    public void registrateAnimalFarm(ArrayList<Farm> animals) {
        int id;
        String color, weight;
        System.out.println("Enter animal farm Id: ");
        id = scanner.nextInt();
        System.out.println("Enter animal color: ");
        color = scanner.next();
        System.out.println("Enter animal weight: ");
        weight = scanner.next();
        
        farm = new Farm(id, color, weight);
        animals.add(farm);
        jsonManager.createJson(animals);
        System.out.println("Animal registrated correctly");
    }
    
    public void deleteAnimalList(ArrayList<Farm> animals) {
        animals.clear();
        System.out.println("All Animal deleted correctly");
        jsonManager.createJson(animals);
    }
    
}
