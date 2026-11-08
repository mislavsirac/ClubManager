package hr.tvz.football.classes;

import hr.tvz.football.abstracts.Person;
import hr.tvz.football.helper.ExceptionHandler;

import java.time.Year;

public class Coach extends Person {
    private int yearsOfExperience;

    public Coach(String name, String lastName, int birthYear, int yearsOfExperience) {
        super(name, lastName, birthYear);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Coach(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public  Coach(){}

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public static Coach InsertCoach(ExceptionHandler inputHandler){
        Coach coach = new Coach();
        int currentYear = Year.now().getValue();

        coach.setName(inputHandler.insertRequiredText("Ime trenera: "));
        coach.setLastName(inputHandler.insertRequiredText("Prezime trenera: "));
        coach.setBirthYear(inputHandler.insertWholeNumber(
                "Godina rođenja trenera: ", 1, currentYear
        ));
        coach.setYearsOfExperience(inputHandler.insertWholeNumber(
                "Godine iskustva: ", 0, Integer.MAX_VALUE
        ));
        System.out.println("\n");

        return  coach;
    }
}
