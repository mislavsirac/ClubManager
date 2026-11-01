package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.records.Address;

import java.util.Scanner;

public class SportsCenter extends Building{
    private int numberOfBeds;
    private boolean hasDiningRoom;

    public SportsCenter(Address address, String name, int numberOfBeds, boolean hasDiningRoom) {
        super(address, name);
        this.numberOfBeds = numberOfBeds;
        this.hasDiningRoom = hasDiningRoom;
    }

    public SportsCenter() {}

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean getHasDiningRoom() {
        return hasDiningRoom;
    }

    public void setHasDiningRoom(boolean hasDiningRoom) {
        this.hasDiningRoom = hasDiningRoom;
    }

    @Override
    public String getBuildingCapacity() {
        return "Broj kreveta: " + numberOfBeds;
    }

    public static String getDescription(SportsCenter sportsCenter, int ordinalNumber, String buildingCapacity) {
        Address address = sportsCenter.getAddress();

        return ordinalNumber + ". Sportski dom: " + sportsCenter.getName() + "\n"
                + "   Adresa: " + address.street() + " " + address.houseNumber()
                + ", " + address.city() + "\n"
                + "   " + buildingCapacity + "\n"
                + "   Ima blagovaonicu: " + sportsCenter.hasDiningRoom;
    }

    @Override
    public String getBuildingDescription(int ordinalNumber, String buildingCapacity) {
        return getDescription(this, ordinalNumber, buildingCapacity);
    }

    public static SportsCenter InsertSportsCenter(Scanner scanner) {
        SportsCenter sportsCenter = new SportsCenter();

        System.out.println("Naziv: ");
        sportsCenter.setName(scanner.nextLine());
        sportsCenter.setAddress(Address.InsertAddress(scanner));
        System.out.println("Broj kreveta: ");
        sportsCenter.setNumberOfBeds(scanner.nextInt());
        System.out.println("Ima blagovaonicu (true/false): ");
        sportsCenter.setHasDiningRoom(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("\n");

        return sportsCenter;
    }
}
