package com.game.state;

import java.util.Scanner;



public class Game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);

        while (!(character.getState() instanceof MasterState)) {

            character.displayStatus();
            System.out.println("Choose action:");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                case 4:
                    System.out.println("Exiting game.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }

            if (character.getHealth() == 0) {
                System.out.println("💀 You have died. Game Over.");
                break;
            }
        }

        if (character.getState() instanceof MasterState) {
            System.out.println("🏆 Congratulations! You completed the game!");
        }

        scanner.close();
    }
}