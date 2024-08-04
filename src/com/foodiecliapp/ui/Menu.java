package com.foodiecliapp.ui;

import com.foodiecliapp.controller.CustomerController;
import com.foodiecliapp.controller.DishController;
import com.foodiecliapp.exceptions.CustomerExistsException;
import com.foodiecliapp.model.Customer;
import com.foodiecliapp.model.Dish;
import com.foodiecliapp.repository.CustomerRepository;
import com.foodiecliapp.service.CustomerServiceImpl;
import com.foodiecliapp.util.Factory;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void displayMainMenu() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("                         WELCOME TO FOODIE APP                         ");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("--------------------------");
            System.out.println("1. Register  (New Customer)");
            System.out.println("2. Login (Existing Customer)");
            System.out.println("3. View Restaurants");
            System.out.println("4. View Dish Menu");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.println("Please enter your choice (1-7)");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    displayRegisterMenu();
                    break;
                case 4:
                    displayDishesList();
                    break;
                case 7:
                    System.out.println("Thank you for using Foodie App, See you again!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");

            }
        }

    }

    private void displayDishesList(){
        DishController dishController = Factory.getDishController();
        List<Dish> dishesList = dishController.getDishesList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Menu Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });
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

    private void displayRegisterMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register entering the following details\n");
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        /*
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        CustomerController customerController = new CustomerController(customerService);
        */
        CustomerController customerController = Factory.getCustomerController();
        try{
            Customer savedCustomer = customerController.save(customer);
            if(savedCustomer != null){
                System.out.println("Customer Registration Successful");
                System.out.println("Details:");
                System.out.println("Id : "+customer.getCustomerId());
                System.out.println("Name :"+ customer.getName());
                System.out.println("E-mail :"+ customer.getEmail());
                System.out.println("Password :"+ customer.getPassword());
            }else{
                System.out.println("some internal error occurred!!! Please try again!");
                displayRegisterMenu();
            }


        }catch(CustomerExistsException e){
            System.out.println(e.getMessage());
            //System.out.println("Customer Already exists with this Id");
            System.out.println("Please login using main menu");
            displayMainMenu();
        }
    }
}
