package hr.tvz.football.abstracts;

import hr.tvz.football.interfaces.BuildingCapacity;
import hr.tvz.football.records.Address;

public abstract class Building implements BuildingCapacity {
    private Address address;
    private String name;

    protected Building(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    protected Building() {}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getBuildingDescription(int ordinalNumber, String buildingCapacity);
}
