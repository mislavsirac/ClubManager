package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Building;
import hr.tvz.football.interfaces.Describable;

import java.util.Scanner;

public class FootballClub implements Describable {
    private String name;
    private String city;
    private int establishedYear;
    private Building[] buildings;
    private Coach coach;
    private Player[] players;

    public FootballClub(String name, String city, int establishedYear, Building[] buildings, Coach coach, Player[] players) {
        this.name = name;
        this.city = city;
        this.establishedYear = establishedYear;
        this.buildings = buildings;
        this.coach = coach;
        this.players = players;
    }

    public FootballClub(){}

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

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getTotalNumberOfBeds() {
        int totalNumberOfBeds = 0;

        for (Building building : buildings) {
            if (building instanceof SportsCenter sportsCenter) {
                totalNumberOfBeds += sportsCenter.getNumberOfBeds();
            }
        }

        return totalNumberOfBeds;
    }

    public static FootballClub[] InsertClubs(int numberOfClubs, Scanner scanner){
        FootballClub[] clubs = new FootballClub[numberOfClubs];

        for(int i = 0; i < numberOfClubs; i++){
            var club = new FootballClub();

            System.out.println("===== UNOS KLUBA " + (i+1) + "=====\n");
            System.out.println("Naziv kluba: ");
            club.setName(scanner.nextLine());
            System.out.println("Grad: ");
            club.setCity(scanner.nextLine());
            System.out.println("Godina osnivanja: ");
            club.setEstablishedYear(scanner.nextInt());
            scanner.nextLine();
            System.out.println("\n");

            club.setCoach(Coach.InsertCoach(scanner));

            System.out.println("Koliko igrača želite unijeti: ");
            var numberOfPlayers = scanner.nextInt();
            scanner.nextLine();

            club.setPlayers(Player.InsertPlayers(scanner, numberOfPlayers));

            System.out.println("Koliko građevina želite unijeti: ");
            var numberOfBuildings = scanner.nextInt();
            scanner.nextLine();

            Building[] buildings = new Building[numberOfBuildings];

            for (int j = 0; j < numberOfBuildings; j++) {
                System.out.println("--- GRAĐEVINA " + (j + 1) + " ---");
                System.out.println("Vrsta (1 - Stadion, 2 - MedicinskaOrdinacija, 3 - SportskiDom): ");
                var buildingType = scanner.nextInt();
                scanner.nextLine();

                switch (buildingType) {
                    case 1:
                        buildings[j] = Stadium.InsertStadium(scanner);
                        break;
                    case 2:
                        buildings[j] = MedicalInstitution.InsertMedicalInstitution(scanner);
                        break;
                    case 3:
                        buildings[j] = SportsCenter.InsertSportsCenter(scanner);
                        break;
                    default:
                        throw new IllegalArgumentException("Nepoznata vrsta građevine: " + buildingType);
                }
            }

            club.setBuildings(buildings);

            clubs[i] = club;
        }

        return clubs;
    }


    @Override
    public String getDescription() {
        String description = "===== " + name.toUpperCase() + " =====\n"
                + "Grad: " + city + "\n"
                + "Godina osnivanja: " + establishedYear + "\n"
                + "Trener: " + coach.getFullName() + "\n\n"
                + "Igrači:\n";

        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            description += (i + 1) + ". " + player.getFullName() + ", "
                    + player.getBirthYear() + "., dres " + player.getNumber()
                    + ", " + player.getPosition() + "\n";
        }

        description += "\nGrađevine:\n\n";

        for (int i = 0; i < buildings.length; i++) {
            Building building = buildings[i];
            if (building == null) {
                continue;
            }

            String buildingCapacity = building.getBuildingCapacity();
            description += building.getBuildingDescription(i + 1, buildingCapacity) + "\n\n";
        }

        description += "Ukupan broj kreveta: " + getTotalNumberOfBeds();
        return description;
    }
}
