package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.helper.ExceptionHandler;
import hr.tvz.football.records.Address;

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

    public static SportsCenter InsertSportsCenter(ExceptionHandler inputHandler) {
        SportsCenter sportsCenter = new SportsCenter();

        sportsCenter.setName(inputHandler.insertRequiredText("Naziv: "));
        sportsCenter.setAddress(Address.InsertAddress(inputHandler));
        sportsCenter.setNumberOfBeds(inputHandler.insertWholeNumber(
                "Broj kreveta: ", 1, Integer.MAX_VALUE
        ));
        sportsCenter.setHasDiningRoom(inputHandler.insertBoolean(
                "Ima blagovaonicu (true/false): "
        ));
        System.out.println("\n");

        return sportsCenter;
    }
}
