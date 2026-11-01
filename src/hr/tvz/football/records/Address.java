package hr.tvz.football.records;

import java.util.Scanner;

public record Address(String street, String houseNumber, String city) {

    public static Address InsertAddress(Scanner scanner){

        System.out.println("Ulica: ");
        var street = scanner.nextLine();
        System.out.println("Kućni broj: ");
        var houseNumber = scanner.nextLine();
        System.out.println("Grad: ");
        var city = scanner.nextLine();

        return new Address(street, houseNumber, city);
    }
}
