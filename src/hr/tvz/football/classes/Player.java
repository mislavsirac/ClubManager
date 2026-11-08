package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Person;
import hr.tvz.football.enums.Position;
import hr.tvz.football.helper.ExceptionHandler;

import java.time.Year;

public class Player extends Person {
    private int number;
    private Position position;

    public Player(String name, String lastName, int birthYear, int number, Position position) {
        super(name, lastName, birthYear);
        this.number = number;
        this.position = position;
    }

    public Player(int number, Position position) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int position) {
        switch(position) {
            case 1:
                this.position =  Position.VRATAR;
                break;
            case 2:
                this.position =  Position.BRANIC;
                break;
            case 3:
                this.position =  Position.VEZNJAK;
                break;
            case 4:
                this.position =  Position.NAPADAC;
                break;
            default:
                throw new IllegalArgumentException("Nepoznata pozicija: " + position);
        }
    }

    public static Player InsertPlayer(ExceptionHandler inputHandler){
        Player player = new Player();
        int currentYear = Year.now().getValue();

        player.setName(inputHandler.insertRequiredText("Ime: "));
        player.setLastName(inputHandler.insertRequiredText("Prezime: "));
        player.setBirthYear(inputHandler.insertWholeNumber(
                "Godina rođenja: ", 1, currentYear
        ));
        player.setNumber(inputHandler.insertWholeNumber("Broj dresa: ", 1, 99));
        player.setPosition(inputHandler.insertPosition(
                "Pozicija (1 - VRATAR, 2 - BRANIC, 3 - VEZNJAK, 4 - NAPADAC): "
        ));
        System.out.println("\n");

        return  player;
    }

    public static Player[] InsertPlayers(ExceptionHandler inputHandler, int numberOfPlayers){
        Player[] players = new Player[numberOfPlayers];

        for(int i=0; i<numberOfPlayers; i++) {
            System.out.println("--- IGRAČ "+ (i+1) + " ---");
            players[i] = InsertPlayer(inputHandler);
        }

        return players;
    }
}
