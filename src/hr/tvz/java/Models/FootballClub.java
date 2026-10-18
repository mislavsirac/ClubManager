package hr.tvz.java.Models;

import java.util.Scanner;

public class FootballClub {
    private String name;
    private String city;
    private int establishedYear;
    private Stadium stadium;
    private Coach coach;
    private Player[] players;

    public FootballClub(String name, String city, int establishedYear, Stadium stadium, Coach coach, Player[] players) {
        this.name = name;
        this.city = city;
        this.establishedYear = establishedYear;
        this.stadium = stadium;
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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
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

    public static FootballClub[] InsertClubs(int numberOfClubs, Scanner scanner){
        FootballClub[] clubs = new FootballClub[numberOfClubs];

        for(int i = 0; i < numberOfClubs; i++){
            var club = new FootballClub();

            System.out.println("===== UNOS KLUBA " + (i+1) + "=====\n");
            System.out.println("Naziv kluba: ");
            club.setName(scanner.next());
            System.out.println("Grad: ");
            club.setCity(scanner.next());
            System.out.println("Godina osnivanja: ");
            club.setEstablishedYear(scanner.nextInt());
            System.out.println("\n");

            club.setStadium(Stadium.InsertStadium(scanner));

            club.setCoach(Coach.InsertCoach(scanner));

            System.out.println("Koliko igrača želite unijeti: ");
            var numberOfPlayers = scanner.nextInt();

            club.setPlayers(Player.InsertPlayers(scanner, numberOfPlayers));

            clubs[i] = club;
        }

        return clubs;
    }
}
