package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.records.Address;

import java.util.Scanner;

public class Stadium extends Building {
    private Integer capacity;
    private Integer yearMade;
    private Boolean covered;

    public Stadium(Address address, String name, Integer capacity, Integer yearMade, Boolean covered) {
        super(address, name);
        this.capacity = capacity;
        this.yearMade = yearMade;
        this.covered = covered;
    }

    public Stadium(){
        super();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getYearMade() {
        return yearMade;
    }

    public void setYearMade(Integer yearMade) {
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

        System.out.println("Naziv: ");
        stadium.setName(scanner.nextLine());
        stadium.setAddress(Address.InsertAddress(scanner));
        System.out.println("Kapacitet: ");
        stadium.setCapacity(scanner.nextInt());
        System.out.println("Godina izgradnje: ");
        stadium.setYearMade(scanner.nextInt());
        System.out.println("Je li stadion natkriven: ");
        stadium.setCovered(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("\n");

        return  stadium;
    }

    @Override
    public String getBuildingCapacity() {
        if (capacity == null) {
            return "Kapacitet: nije unesen";
        }

        return "Kapacitet: " + capacity + " gledatelja";
    }

    public static String getDescription(Stadium stadium, int ordinalNumber, String buildingCapacity) {
        Address address = stadium.getAddress();

        return ordinalNumber + ". Stadion: " + stadium.getName() + "\n"
                + "   Adresa: " + address.street() + " " + address.houseNumber()
                + ", " + address.city() + "\n"
                + "   " + buildingCapacity + "\n"
                + "   Godina izgradnje: " + stadium.yearMade + "\n"
                + "   Natkriven: " + stadium.covered;
    }

    @Override
    public String getBuildingDescription(int ordinalNumber, String buildingCapacity) {
        return getDescription(this, ordinalNumber, buildingCapacity);
    }
}
