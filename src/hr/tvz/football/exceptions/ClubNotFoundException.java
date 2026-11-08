package hr.tvz.football.exceptions;

public class ClubNotFoundException extends Exception {
    public ClubNotFoundException(String clubName) {
        super("Klub '" + clubName + "' nije pronađen.");
    }
}
