package hr.tvz.java.Models;

import java.util.Scanner;

public class Stadium {
    private String name;
    private String city;
    private Integer capacity;
    private Integer yearMade;
    private Boolean covered;

    public Stadium(String name, String city, int capacity, int yearMade, Boolean covered) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.yearMade = yearMade;
        this.covered = covered;
    }

    public Stadium(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public Boolean getCovered() {
        return covered;
    }

    public void setCovered(Boolean covered) {
        this.covered = covered;
    }

    public static Stadium InsertStadium(Scanner scanner){
        Stadium stadium = new Stadium();

        System.out.println("Naziv stadiona: ");
        stadium.setName(scanner.next());
        System.out.println("Grad stadiona: ");
        stadium.setCity(scanner.next());
        System.out.println("Kapacitet: ");
        stadium.setCapacity(scanner.nextInt());
        System.out.println("Godina izgradnje: ");
        stadium.setYearMade(scanner.nextInt());
        System.out.println("Je li stadion natkriven: ");
        stadium.setCovered(scanner.nextBoolean());
        System.out.println("\n");

        return  stadium;
    }
}
