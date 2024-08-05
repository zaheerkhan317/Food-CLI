package com.foodiecliapp.ui;

import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void displayMenu() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenuHeader("WELCOME TO FOODIE APP");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Customer Section");
            System.out.println("2. Restaurant Section");
            System.out.println("3. Dishes Section");
            System.out.println("4. Order Section ");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice (1-5)");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> new CustomerMenu().displayMenu();
                case 2 -> new RestaurantsMenu().displayMenu();
                case 3 -> new DishesMenu().displayMenu();
                case 4 -> new OrdersMenu().displayMenu();

                default ->
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");

            }
        }

    }

    public void displayMenuHeader(String menuHeader) {
        printDashLine();
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        printDashLine();
    }

    public void printDashLine(){
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
    }

}
