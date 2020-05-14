package demo;

public class Program {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    //private PizzaList pizzaList = new PizzaList();
    //private OrdersList ordersList = new OrdersList();
    private UI ui = new UI();
    private MenuController menuController = new MenuController();
    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
    public Program() {
      //  new GenerateFromFile(pizzaList, ordersList);
        run();
    }
    // ------------------------------------------------------
    // METHODS
    // ------------------------------------------------------
    private void run() {
        while (true) {
            ui.clear();
            menuController.run();
            ui.printString("\nTryk enter for menu");
            ui.scannerLine();
        }
    }
}