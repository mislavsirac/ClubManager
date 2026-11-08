package hr.tvz.football.app;

import hr.tvz.football.classes.FootballClub;
import hr.tvz.football.exceptions.ClubNotFoundException;
import hr.tvz.football.helper.ExceptionHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        try {
            var inputHandler = new ExceptionHandler(scanner);
            var numberOfClubs = inputHandler.insertWholeNumber(
                    "Koliko klubova želite unijeti: ", 1, Integer.MAX_VALUE
            );

            var clubs = FootballClub.InsertClubs(numberOfClubs, inputHandler);

            NavigationMenu(inputHandler, clubs);
        } finally {
            scanner.close();
            System.out.println("Program je završio.");
        }
    }

    private static void NavigationMenu(ExceptionHandler inputHandler, FootballClub[] clubs){
        int selection = 1;

        while (selection != 0){

            System.out.println("===== NOGOMETNI KLUBOVI =====\n");
            System.out.println("1 - Pretraži klub");
            System.out.println("0 - Završi program");
            selection = inputHandler.insertListOption("Odabir: ", 0, 1);

            if (selection == 1)
                ClubSearch(inputHandler, clubs);
        }
    }

    private static void ClubSearch(ExceptionHandler inputHandler, FootballClub[] clubs){
        var searchString = inputHandler.insertRequiredText("\nUnesite naziv kluba: ");

        try {
            var match = FindClub(clubs, searchString);
            System.out.println(match.getDescription());
        } catch (ClubNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static FootballClub FindClub(FootballClub[] clubs, String name)
            throws ClubNotFoundException {
        for (FootballClub club : clubs) {
            if (club.getName().equalsIgnoreCase(name)) {
                return club;
            }
        }

        throw new ClubNotFoundException(name);
    }

}
