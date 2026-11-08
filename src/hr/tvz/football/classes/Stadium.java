package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.helper.ExceptionHandler;
import hr.tvz.football.records.Address;

import java.time.Year;

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

    public static Stadium InsertStadium(ExceptionHandler inputHandler){
        Stadium stadium = new Stadium();

        stadium.setName(inputHandler.insertRequiredText("Naziv: "));
        stadium.setAddress(Address.InsertAddress(inputHandler));
        stadium.setCapacity(inputHandler.insertOptinalWholeNumber(
                "Kapacitet (Enter = nije unesen): ", 1, Integer.MAX_VALUE
        ));
        stadium.setYearMade(inputHandler.insertOptinalWholeNumber(
                "Godina izgradnje (Enter = nije unesena): ", 1, Year.now().getValue()
        ));
        stadium.setCovered(inputHandler.insertOptionalBoolean(
                "Natkriven (true/false, Enter = nije uneseno): "
        ));
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
