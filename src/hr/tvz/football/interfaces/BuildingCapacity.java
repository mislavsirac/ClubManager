package hr.tvz.football.interfaces;

public interface BuildingCapacity extends Describable{
    public String getBuildingCapacity();

    @Override
    default String getDescription() {
        return getBuildingCapacity();
    }
}
