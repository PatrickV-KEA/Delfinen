package demo;

public class MenuController {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    private PizzaList pizzaList;
    private OrdersList ordersList;
    private UI ui;
    private MenuOrders menuOrders;
    private FileHandler fileHandler = new FileHandler(ordersList, pizzaList);
    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
    public MenuController(PizzaList pizzaList, OrdersList ordersList, UI ui) {
        this.pizzaList = pizzaList;
        this.ordersList = ordersList;
        this.ui = ui;
        this.menuOrders = new MenuOrders(ordersList, pizzaList, ui);
    }
    // ------------------------------------------------------
    // METHODS
    // ------------------------------------------------------
    public void run() {
        ui.printString("Tryk 1 Se bestillinger");
        ui.printString("Tryk 2 Tilføj bestilling");
        ui.printString("Tryk 3 Færdiggør bestilling");
        ui.printString("Tryk 4 Annuller bestilling");
        ui.printString("Tryk 5 Se menukort");
        ui.printString("Tryk 6 Se statistik");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //print aktive bestillinger
                    ui.clear();
                    ui.printArraylist(ordersList.getSortedOrders());
                    break;
                case 2:
                    //tilføj bestilling
                    ui.clear();
                    menuOrders.addOrder();
                    break;
                case 3:
                    //færdiggør bestilling
                    Order order;
                    ui.clear();
                    ui.printArraylist(ordersList.getSortedOrders());
                    ui.printString("Færdiggør ordre. \nIndtast ordre nummer:");
                    menuOrders.removeOrder(ui.scannerInt(), true);
                    break;
                case 4:
                    //annuller bestilling
                    ui.clear();
                    ui.printArraylist(ordersList.getSortedOrders());
                    ui.printString("Annuller ordre. \nIndtast ordre nummer:");
                    menuOrders.removeOrder(ui.scannerInt(), false);
                    break;
                case 5:
                    //se menukort
                    ui.clear();
                    ui.printArraylist(pizzaList.getMenu());
                    break;
                case 6:
                    //se statestik
                    ui.clear();
                    ui.printArraylist(fileHandler.getStatistics());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}