/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

import ec.edu.espe.model.JsonManager;
import ec.edu.espe.model.Farm;
import ec.edu.espe.controller.FarmController;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class Menu {
    Scanner scanner = new Scanner(System.in);
    Farm animal;
    ArrayList<Farm> animals = new ArrayList<>();
    FarmController FarmController = new FarmController();

    public void menu() {
        int option;
        do{
            System.out.println("1.Enter animal Farm Id");
            System.out.println("2.Delete all animal");
            System.out.println("3.Close");
            option = scanner.nextInt();

                switch(option) {
                    case 1:
                        FarmController.registrateAnimalFarm(animals);
                    break;
                    case 2:
                        FarmController.deleteAnimalList(animals);
                    break;
                    case 3: 
                        System.out.println("Leaving....");
                    break;
                }
        }while(option != 3);
    }
}