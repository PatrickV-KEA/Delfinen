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
                    //træner menu
                    CoachMenu.menu();//noget med static
                    break;
                case 2:
                    //kasser menu
                    EconomicsMenu.menu();//noget med static
                    break;
                case 3:
                    //formands menu
                    BoardMenu.menu();//noget med static
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}