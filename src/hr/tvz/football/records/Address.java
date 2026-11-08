package hr.tvz.football.records;

import hr.tvz.football.helper.ExceptionHandler;

public record Address(String street, String houseNumber, String city) {

    public static Address InsertAddress(ExceptionHandler inputHandler){
        var street = inputHandler.insertRequiredText("Ulica: ");
        var houseNumber = inputHandler.insertRequiredText("Kućni broj: ");
        var city = inputHandler.insertRequiredText("Grad: ");

        return new Address(street, houseNumber, city);
    }
}
