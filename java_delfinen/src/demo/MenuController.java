package demo;

public class MenuController {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    UI ui = new UI;
    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
    public MenuController(PizzaList pizzaList, OrdersList ordersList, UI ui) {

    }
    // ------------------------------------------------------
    // METHODS
    // ------------------------------------------------------
    public void run() {
        ui.printString("Tryk 1 For træner");
        ui.printString("Tryk 2 For kasseren");
        ui.printString("Tryk 3 For formanden");
        //ui.printString("Tryk 4 Annuller bestilling");
        //ui.printString("Tryk 5 Se menukort");
        //ui.printString("Tryk 6 Se statistik");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //print aktive bestillinger

                    break;
                case 2:
                    //tilføj bestilling

                    break;
                case 3:
                    //færdiggør bestilling

                    break;
                /*case 4:
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
                    break;*/
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}