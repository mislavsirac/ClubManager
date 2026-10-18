package hr.tvz.java.Models;

import java.util.Scanner;

public class Coach extends Person{
    private int yearsOfExperience;

    public Coach(String name, String lastName, int birthYear, int yearsOfExperience) {
        super(name, lastName, birthYear);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Coach(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public  Coach(){}

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public static Coach InsertCoach(Scanner scanner){
        Coach coach = new Coach();

        System.out.println("Ime trenera: ");
        coach.setName(scanner.next());
        System.out.println("Prezime trenera: ");
        coach.setLastName(scanner.next());
        System.out.println("Godina rođenja: ");
        coach.setBirthYear(scanner.nextInt());
        System.out.println("Godine iskustva: ");
        coach.setYearsOfExperience(scanner.nextInt());
        System.out.println("\n");

        return  coach;
    }
}
