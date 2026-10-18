package hr.tvz.java;

import hr.tvz.java.Models.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Koliko klubova želite unijeti: ");
        var numberOfClubs = scanner.nextInt();

        var clubs = FootballClub.InsertClubs(numberOfClubs, scanner);

        NavigationMenu(scanner, clubs);
    }

    private static void NavigationMenu(Scanner scanner, FootballClub[] clubs){
        int selection = 1;

        while (selection != 0){

            System.out.println("===== NOGOMETNI KLUBOVI =====\n");
            System.out.println("1 - Pretraži klub");
            System.out.println("0 - Završi program");

            selection = scanner.nextInt();

            if (selection == 1)
                ClubSearch(scanner, clubs);
        }
    }

    private static void ClubSearch(Scanner scanner, FootballClub[] clubs){

        System.out.println("\nUnesite naziv kluba: ");
        var searchString = scanner.next();

        var match = Arrays.stream(clubs)
                .filter(x -> x.getName().equalsIgnoreCase(searchString))
                .findFirst()
                .orElse(null);

        if(match == null){
            System.out.println("Nema kluba s tim nazivom.\n");
            return;
        }

        System.out.println("===== " + match.getName().toUpperCase() + " =====");
        System.out.println("Grad: " + match.getCity());
        System.out.println("Godina osnivanja: " + match.getEstablishedYear());
        System.out.println("Trener: " + match.getCoach().getFullName());
        System.out.println("Stadion: " + match.getStadium().getName() + "\n");
    }

}