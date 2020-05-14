package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
/*
public class GenerateFromFile {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    private PizzaList pizzaList;
    private OrdersList ordersList;

    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
    GenerateFromFile(PizzaList pizzaList, OrdersList ordersList) {
        this.pizzaList = pizzaList;
        this.ordersList = ordersList;
        generatePizzaMenu();
        generateOrdersList();
    }
    // ------------------------------------------------------
    // METHODS
    // ------------------------------------------------------
    public void generatePizzaMenu() {
        //takes the menu from the .txt and puts it into the arraylist
        File file = new File("pizzaMenu.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                Pizza pizza = new Pizza(scan.nextInt(), scan.next(), scan.nextInt(), scan.nextLine());
                pizzaList.addPizza(pizza);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateOrdersList() {
        ArrayList<Order> orders = new ArrayList<>();
        File file = new File("activeOrders.txt");
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                try {
                    String line = scan.nextLine();
                    if (line.isEmpty()) {
                        continue;
                    } else {
                        orders.add(generateSingleOrder(line));
                    }
                } catch (IllegalArgumentException e) {
                    e.getMessage();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ordersList.setOrders(orders);
    }
    private Order generateSingleOrder(String line) {
        // "1 : 10:45 : Patrick : 1,5,12,4 : Standard"
        Scanner delimited = new Scanner(line).useDelimiter("\\s*:\\s*");

        int orderNumber = delimited.nextInt();
        LocalTime time = generateLocalTimeFromString(delimited.next()+":"+delimited.next());
        String customer = delimited.next();
        String pizzaNumbers = delimited.next();
        String note = delimited.nextLine();

        // "1,5,12,4"
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Scanner delimitedPizzaNumbers = new Scanner(pizzaNumbers).useDelimiter("\\s*,\\s*");
        while (delimitedPizzaNumbers.hasNext()) {
            pizzas.add(pizzaList.getPizzaFromNumber(delimitedPizzaNumbers.nextInt()));
        }

        Order newOrder = new Order(orderNumber, pizzas, time, customer, note);
        return newOrder;
    }
    private LocalTime generateLocalTimeFromString(String str) {
        //Splits time string into hrs & min and parses to ints, then inputs to LocalTime8
        Scanner scan = new Scanner(str).useDelimiter("\\s*:\\s*");
        int HH = Integer.parseInt(scan.next());
        int MM = Integer.parseInt(scan.next());
        scan.close();
        return LocalTime.of(HH, MM);
    }
}*/