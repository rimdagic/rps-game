package org.example.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void display() {
        System.out.println("\n\nMain menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getDisplayChoice());
        }
        System.out.println("0. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            display();
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= menuItems.size()) {
                menuItems.get(choice - 1).execute();
            } else if (choice != 0) {
                System.out.println("Invalid choice, try again!");
            }

        } while (choice != 0);
    }
}