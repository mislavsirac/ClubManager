package hr.tvz.football.helper;

import hr.tvz.football.enums.Position;

import java.util.Scanner;

public class ExceptionHandler {
    private final Scanner scanner;

    public ExceptionHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String insertRequiredText(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("Pogreška: tekst ne smije biti prazan.");
        }
    }

    public int insertWholeNumber(String message, int min, int max) {
        while (true) {
            System.out.print(message);

            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                validateRange(number, min, max);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Pogreška: potrebno je unijeti cijeli broj.");
            } catch (IllegalArgumentException e) {
                System.out.println("Pogreška: " + e.getMessage());
            }
        }
    }

    public Integer insertOptinalWholeNumber(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }

            try {
                int number = Integer.parseInt(input);
                validateRange(number, min, max);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Pogreška: potrebno je unijeti cijeli broj.");
            } catch (IllegalArgumentException e) {
                System.out.println("Pogreška: " + e.getMessage());
            }
        }
    }

    public boolean insertBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(input);
            }

            System.out.println("Pogreška: unesite true ili false.");
        }
    }

    public Boolean insertOptionalBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(input);
            }

            System.out.println("Pogreška: unesite true ili false.");
        }
    }

    public Position insertPosition(String message) {
        int selection = insertListOption(message, 1, 4);

        return switch (selection) {
            case 1 -> Position.VRATAR;
            case 2 -> Position.BRANIC;
            case 3 -> Position.VEZNJAK;
            case 4 -> Position.NAPADAC;
            default -> throw new IllegalArgumentException("Nepoznata pozicija: " + selection);
        };
    }

    public int insertListOption(String message, int min, int max) {
        return insertWholeNumber(message, min, max);
    }

    private void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            if (max == Integer.MAX_VALUE) {
                throw new IllegalArgumentException("vrijednost mora biti najmanje " + min + ".");
            }

            throw new IllegalArgumentException(
                    "vrijednost mora biti između " + min + " i " + max + "."
            );
        }
    }
}
