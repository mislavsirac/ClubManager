package hr.tvz.java.Models;

import java.util.Scanner;

public class Player extends Person{
    private int number;
    private String position;

    public Player(String name, String lastName, int birthYear, int number, String position) {
        super(name, lastName, birthYear);
        this.number = number;
        this.position = position;
    }

    public Player(int number, String position) {
        this.number = number;
        this.position = position;
    }

    public Player() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Player InsertPlayer(Scanner scanner){
        Player player = new Player();

        System.out.println("Ime: ");
        player.setName(scanner.next());
        System.out.println("Prezime: ");
        player.setLastName(scanner.next());
        System.out.println("Godina rođenja: ");
        player.setBirthYear(scanner.nextInt());
        System.out.println("Broj dresa: ");
        player.setNumber(scanner.nextInt());
        System.out.println("Pozicija: ");
        player.setPosition(scanner.next());
        System.out.println("\n");

        return  player;
    }

    public static Player[] InsertPlayers(Scanner scanner, int numberOfPlayers){
        Player[] players = new Player[numberOfPlayers];

        for(int i=0; i<numberOfPlayers; i++) {
            System.out.println("--- IGRAČ "+ (i+1) + " ---");
            players[i] = InsertPlayer(scanner);
        }

        return  players;
    }
}
