package hr.tvz.football.app;

import hr.tvz.football.classes.FootballClub;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Koliko klubova želite unijeti: ");
        var numberOfClubs = scanner.nextInt();
        scanner.nextLine();

        var clubs = FootballClub.InsertClubs(numberOfClubs, scanner);

        NavigationMenu(scanner, clubs);
    }

    private static void NavigationMenu(Scanner scanner, FootballClub[] clubs){
        int selection = 1;

        while (selection != 0){

            System.out.println("===== NOGOMETNI KLUBOVI =====\n");
            System.out.println("1 - Pretraži klub");
            System.out.println("0 - Završi program");
            System.out.println("Odabir: ");

            selection = scanner.nextInt();
            scanner.nextLine();

            if (selection == 1)
                ClubSearch(scanner, clubs);
        }
    }

    private static void ClubSearch(Scanner scanner, FootballClub[] clubs){

        System.out.println("\nUnesite naziv kluba: ");
        var searchString = scanner.nextLine();

        var match = Arrays.stream(clubs)
                .filter(x -> x.getName().equalsIgnoreCase(searchString))
                .findFirst()
                .orElse(null);

        if(match == null){
            System.out.println("Nema kluba s tim nazivom.\n");
            return;
        }

        System.out.println(match.getDescription());
    }

}
