package demo;

public class EconomicsMenu {

    UI ui = new UI();


    public void menu() {
        ui.printString("Du har nu følgende muligheder");
        ui.printString("Tryk 1 For restance listen");
        ui.printString("Tryk 2 For medlemslisten");
        ui.printString("Tryk 3 For Opdatere et medlems informationer");
        ui.printString("tryk 4 for at indskrive en betaling");
        ui.printString("Tryk 5 for årest samlede kontingent");
        ui.print(">>");
        try {
            switch (ui.scannerInt()) {
                case 1:
                    //restance liste

                    break;
                case 2:
                    //medlemsliste

                    break;
                case 3:
                    //opdater info

                    break;
                case 4:
                    //indkriv betaling

                    break;
                case 5:
                    //se samlede kontingent

                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();


        }

    }
