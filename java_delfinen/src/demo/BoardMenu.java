package demo;

public class BoardMenu {
UI ui = new UI;
    public void menu (){
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

                    break;
                case 2:
                    //kasser menu

                    break;
                case 3:
                    //formands menu

                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();


        /*
        1. indmeldese
         */

    }

}
