package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.records.Address;

import java.util.Scanner;

public class MedicalInstitution extends Building {
    private int numberOfClinics;
    private boolean hasEmergencyService;

    public MedicalInstitution(Address address, String name, int numberOfClinics, boolean hasEmergencyService) {
        super(address, name);
        this.numberOfClinics = numberOfClinics;
        this.hasEmergencyService = hasEmergencyService;
    }

    public MedicalInstitution() {}

    public int getNumberOfClinics() {
        return numberOfClinics;
    }

    public void setNumberOfClinics(int numberOfClinics) {
        this.numberOfClinics = numberOfClinics;
    }

    public boolean getHasEmergencyService() {
        return hasEmergencyService;
    }

    public void setHasEmergencyService(boolean hasEmergencyService) {
        this.hasEmergencyService = hasEmergencyService;
    }

    @Override
    public String getBuildingCapacity() {
        return "Broj ambulanti: " + numberOfClinics;
    }

    public static String getDescription(MedicalInstitution medicalInstitution, int ordinalNumber,
                                        String buildingCapacity) {
        Address address = medicalInstitution.getAddress();

        return ordinalNumber + ". Medicinska ordinacija: " + medicalInstitution.getName() + "\n"
                + "   Adresa: " + address.street() + " " + address.houseNumber()
                + ", " + address.city() + "\n"
                + "   " + buildingCapacity + "\n"
                + "   Ima hitnu službu: " + medicalInstitution.hasEmergencyService;
    }

    @Override
    public String getBuildingDescription(int ordinalNumber, String buildingCapacity) {
        return getDescription(this, ordinalNumber, buildingCapacity);
    }

    public static MedicalInstitution InsertMedicalInstitution(Scanner scanner) {
        MedicalInstitution medicalInstitution = new MedicalInstitution();

        System.out.println("Naziv: ");
        medicalInstitution.setName(scanner.nextLine());
        medicalInstitution.setAddress(Address.InsertAddress(scanner));
        System.out.println("Broj ambulanti: ");
        medicalInstitution.setNumberOfClinics(scanner.nextInt());
        System.out.println("Ima hitnu službu (true/false): ");
        medicalInstitution.setHasEmergencyService(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("\n");

        return medicalInstitution;
    }
}
